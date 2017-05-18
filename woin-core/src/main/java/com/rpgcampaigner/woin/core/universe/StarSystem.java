package com.rpgcampaigner.woin.core.universe;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jmccormick
 * @since 5/16/17
 */
public class StarSystem {
	private Set<Star> stars = new HashSet<>();

	// TODO make this a set sorted by auDistance
	private Set<PlanetaryBody> planetaryBodies = new HashSet<>();

	public Set<Star> getStars() {
		return stars;
	}

	public Set<PlanetaryBody> getPlanetaryBodies() {
		return planetaryBodies;
	}
}
