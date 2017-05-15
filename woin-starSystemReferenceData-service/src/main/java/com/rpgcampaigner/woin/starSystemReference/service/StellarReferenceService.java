package com.rpgcampaigner.woin.starSystemReference.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.rpgcampaigner.woin.core.universe.SpectralType;
import com.rpgcampaigner.woin.starSystemReference.model.SpectralTypeDefinition;

import io.advantageous.qbit.annotation.RequestMapping;
import io.advantageous.qbit.annotation.RequestMethod;

/**
 * @author jmccormick
 * @since 5/15/17
 */
@RequestMapping("/woin/starSystemReference/stellar")
public class StellarReferenceService {

	private static Set<SpectralTypeDefinition> spectralTypeDefinitions = new HashSet<>();

	static {
		Arrays.stream(SpectralType.values()).forEach(spectralType ->
				spectralTypeDefinitions.add(new SpectralTypeDefinition(spectralType)));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test() {
		return "stellar reference data";
	}

	@RequestMapping(value = "/spectralClasses", method = RequestMethod.GET)
	public Set<SpectralTypeDefinition> getSpectralTypes() {
		System.out.println("Custom definition version");
		return spectralTypeDefinitions;
	}
}
