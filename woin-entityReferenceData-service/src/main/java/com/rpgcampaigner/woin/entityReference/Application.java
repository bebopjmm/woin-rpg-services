package com.rpgcampaigner.woin.entityReference;

import com.rpgcampaigner.woin.entityReference.dal.CouchbaseConfiguration;
import com.rpgcampaigner.woin.entityReference.dal.DynamoConfiguration;
import com.rpgcampaigner.woin.entityReference.dal.ReferenceCouchbaseRepository;
import com.rpgcampaigner.woin.entityReference.dal.ReferenceRepository;
import com.rpgcampaigner.woin.entityReference.domain.ReferenceManager;
import com.rpgcampaigner.woin.entityReference.service.SkillService;

import io.advantageous.qbit.server.EndpointServerBuilder;
import io.advantageous.qbit.server.ServiceEndpointServer;

/**
 * @author jmccormick
 * @since 3/14/17
 */
public class Application {

	public static void main(String[] args) throws Exception {
		CouchbaseConfiguration couchbaseConfiguration = new CouchbaseConfiguration("localhost", "woin-reference");
		DynamoConfiguration dynamoConfiguration = new DynamoConfiguration("woin-reference");

		ReferenceRepository referenceRepository = new ReferenceCouchbaseRepository(couchbaseConfiguration.getReferenceBucket());
		ReferenceManager referenceManager = new ReferenceManager(referenceRepository);
		ServiceEndpointServer server = new EndpointServerBuilder().build();
		server.initServices(new SkillService(referenceManager, referenceRepository));
		server.start();
	}
}
