package com.rpgcampaigner.woin.starSystemReference.model;

import com.rpgcampaigner.woin.core.universe.SpectralType;

/**
 * This custom output definition is needed to get all the metadata captured in the SpectralType enumeration
 * 
 * @author jmccormick
 * @since 5/15/17
 */
public class SpectralTypeDefinition {
	final String code;

	final String description;

	public SpectralTypeDefinition(SpectralType spectralType) {
		this.code = spectralType.name();
		this.description = spectralType.getDescription();
	}
}
