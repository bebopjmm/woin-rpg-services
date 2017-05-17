package com.rpgcampaigner.woin.core.universe;

/**
 * @author jmccormick
 * @since 5/16/17
 */
public enum PlanetaryType {
	A("asteroid/planetoid belt", false),
	G("gas", false),
	I("icy", true),
	R("ruined", true),
	W("water", true),
	D("desert", true),
	B("barren", true),
	V("volcanic", true),
	S("swamp", true),
	J("jungle", true),
	M("terrestrial/mixed", true);

	String description;
	boolean isRocky;

	PlanetaryType(String description, boolean isRocky) {
		this.description = description;
		this.isRocky = isRocky;
	}
}
