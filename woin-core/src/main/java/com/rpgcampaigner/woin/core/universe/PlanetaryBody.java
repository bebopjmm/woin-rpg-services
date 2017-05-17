package com.rpgcampaigner.woin.core.universe;

import java.util.Optional;

/**
 * @author jmccormick
 * @since 5/16/17
 */
public class PlanetaryBody {
	private float auDistance;
	private String stellarCode;
	private PlanetaryType planetaryType;
	private Optional<String> name = Optional.empty();


	public String getStellarCode() {
		return stellarCode;
	}

	public void setStellarCode(String stellarCode) {
		this.stellarCode = stellarCode;
	}

	public PlanetaryType getPlanetaryType() {
		return planetaryType;
	}

	public void setPlanetaryType(PlanetaryType planetaryType) {
		this.planetaryType = planetaryType;
	}

	public float getAuDistance() {
		return auDistance;
	}

	public void setAuDistance(float auDistance) {
		this.auDistance = auDistance;
	}
}
