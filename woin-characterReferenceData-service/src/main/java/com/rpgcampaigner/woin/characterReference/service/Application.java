package com.rpgcampaigner.woin.characterReference.service;

import io.advantageous.qbit.server.EndpointServerBuilder;
import io.advantageous.qbit.server.ServiceEndpointServer;

/**
 * @author jmccormick
 * @since 3/14/17
 */
public class Application {

	public static void main(String[] args) throws Exception {
		ServiceEndpointServer server = new EndpointServerBuilder().build();
		server.initServices(new SkillService());
		server.start();
	}
}
