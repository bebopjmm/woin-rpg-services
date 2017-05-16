package com.rpgcampaigner.woin.starSystem;

import com.rpgcampaigner.woin.starSystem.service.StarSystemService;

import io.advantageous.qbit.server.EndpointServerBuilder;
import io.advantageous.qbit.server.ServiceEndpointServer;

/**
 * @author jmccormick
 * @since 5/15/17
 */
public class Application {
	public static void main(String[] args) throws Exception {
		ServiceEndpointServer server = new EndpointServerBuilder().build();
		server.initServices(new StarSystemService());
		server.start();
	}
}
