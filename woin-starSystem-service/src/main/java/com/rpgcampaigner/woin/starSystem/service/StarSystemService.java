package com.rpgcampaigner.woin.starSystem.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.rpgcampaigner.woin.core.universe.SpectralType;
import com.rpgcampaigner.woin.core.universe.StarSystem;
import com.rpgcampaigner.woin.starSystem.domain.StarSystemGenerator;
import com.rpgcampaigner.woin.starSystem.model.SpectralTypeDefinition;
import com.rpgcampaigner.woin.starSystem.model.StarSystemDefinition;

import io.advantageous.qbit.annotation.RequestMapping;
import io.advantageous.qbit.annotation.RequestMethod;

/**
 * @author jmccormick
 * @since 5/15/17
 */
@RequestMapping("/starSystem")
public class StarSystemService {

	private static Set<SpectralTypeDefinition> spectralTypeDefinitions = new HashSet<>();
	static {
		Arrays.stream(SpectralType.values()).forEach(spectralType ->
				spectralTypeDefinitions.add(new SpectralTypeDefinition(spectralType)));
	}

	private StarSystemGenerator starSystemGenerator;

	public StarSystemService(StarSystemGenerator generator) {
		this.starSystemGenerator = generator;
	}

	@RequestMapping(value = "/spectralClasses", method = RequestMethod.GET)
	public Set<SpectralTypeDefinition> getSpectralTypes() {
		System.out.println("Custom definition version");
		return spectralTypeDefinitions;
	}

	@RequestMapping(value = "/generate", method = RequestMethod.GET)
	public StarSystemDefinition generate() {
		System.out.println("Generating a star system");
		StarSystem system = starSystemGenerator.randomStarSystem.get();
		StarSystemDefinition definition = new StarSystemDefinition(system);
		System.out.println("++ definition total planets = " + definition.getPlanetaryBodies().size());
		return definition;
	}
}
