package com.rpgcampaigner.woin.core.universe;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jmccormick
 * @since 5/16/17
 */
public class StarSystem {
	private Set<Star> stars = new HashSet<>();

	private Set<PlanetaryBody> planetaryBodies = new TreeSet<>();

	public Set<Star> getStars() {
		return stars;
	}

	public Set<PlanetaryBody> getPlanetaryBodies() {
		return planetaryBodies;
	}
}
