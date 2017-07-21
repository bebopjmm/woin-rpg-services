package com.rpgcampaigner.woin.entityReference;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

import com.rpgcampaigner.woin.entityReference.dal.DynamoConfiguration;
import com.rpgcampaigner.woin.entityReference.dal.ReferenceDynamoRepository;
import com.rpgcampaigner.woin.entityReference.dal.ReferenceRepository;
import com.rpgcampaigner.woin.entityReference.service.SkillService;

import io.advantageous.qbit.admin.ManagedServiceBuilder;
import io.advantageous.qbit.server.EndpointServerBuilder;
import io.advantageous.qbit.server.ServiceEndpointServer;

/**
 * @author jmccormick
 * @since 3/14/17
 */
public class Application {

	public static void main(String[] args) throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream is = classLoader.getResourceAsStream("dynamoConfig.yaml");
		Yaml yaml = new Yaml();
		DynamoConfiguration dynamoConfiguration = yaml.loadAs(is, DynamoConfiguration.class);

		ReferenceRepository referenceRepository = new ReferenceDynamoRepository(dynamoConfiguration);

		// Build and start the server
		final ManagedServiceBuilder managedServiceBuilder = ManagedServiceBuilder.managedServiceBuilder();
		final ServiceEndpointServer server = managedServiceBuilder.getEndpointServerBuilder()
				.setUri("/woin").build()
				.initServices(new SkillService(referenceRepository))
				.startServer();

		// Wait for service to shutdown
		managedServiceBuilder.getSystemManager().waitForShutdown();
	}
}
