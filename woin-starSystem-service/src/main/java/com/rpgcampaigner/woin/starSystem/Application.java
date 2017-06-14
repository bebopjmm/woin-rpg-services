package com.rpgcampaigner.woin.starSystem;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

import com.rpgcampaigner.woin.starSystem.domain.StarSystemGenerator;
import com.rpgcampaigner.woin.starSystem.domain.StarSystemGeneratorConfig;
import com.rpgcampaigner.woin.starSystem.service.StarSystemService;

import io.advantageous.qbit.server.EndpointServerBuilder;
import io.advantageous.qbit.server.ServiceEndpointServer;

/**
 * @author jmccormick
 * @since 5/15/17
 */
public class Application {
	public static void main(String[] args) throws Exception {
		// Build the Star System Service
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream is = classLoader.getResourceAsStream("starSystemGeneratorConfig.yaml");
		Yaml yaml = new Yaml();
		StarSystemGeneratorConfig starSystemGeneratorConfig = yaml.loadAs(is, StarSystemGeneratorConfig.class);
		StarSystemGenerator systemGenerator = new StarSystemGenerator(starSystemGeneratorConfig);

		// Build and start the server
		ServiceEndpointServer server = new EndpointServerBuilder().build();
		server.initServices(new StarSystemService(systemGenerator));
		server.start();
	}

}
