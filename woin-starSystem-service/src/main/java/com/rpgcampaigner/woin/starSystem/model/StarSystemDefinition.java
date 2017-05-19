package com.rpgcampaigner.woin.starSystem.model;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.rpgcampaigner.woin.core.universe.Star;
import com.rpgcampaigner.woin.core.universe.StarSystem;

/**
 * @author jmccormick
 * @since 5/18/17
 */
public class StarSystemDefinition {
	private Set<Star> stars = new HashSet<>();
	private Set<PlanetaryBodyDefinition> planetaryBodies = new TreeSet<>();

	public StarSystemDefinition(StarSystem starSystem) {
		this.stars = starSystem.getStars();
		System.out.println("-- total planets for definiton = " + starSystem.getPlanetaryBodies().size());
		starSystem.getPlanetaryBodies().stream()
				.forEach(planet -> this.planetaryBodies.add(new PlanetaryBodyDefinition(planet)));
	}
	public Set<Star> getStars() {
		return stars;
	}

	public Set<PlanetaryBodyDefinition> getPlanetaryBodies() {
		return planetaryBodies;
	}
}
