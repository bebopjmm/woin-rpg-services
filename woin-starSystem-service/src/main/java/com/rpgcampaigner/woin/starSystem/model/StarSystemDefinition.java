package com.rpgcampaigner.woin.starSystem.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.rpgcampaigner.woin.core.universe.Star;
import com.rpgcampaigner.woin.core.universe.StarSystem;

/**
 * @author jmccormick
 * @since 5/18/17
 */
public class StarSystemDefinition {
	private Set<Star> stars = new HashSet<>();
	private Set<PlanetaryBodyDefinition> planetaryBodies;

	public StarSystemDefinition(StarSystem starSystem) {
		this.stars = starSystem.getStars();
		System.out.println("-- total planets for definiton = " + starSystem.getPlanetaryBodies().size());
		List planetList = starSystem.getPlanetaryBodies().stream()
				.map(planet -> new PlanetaryBodyDefinition(planet))
				.collect(Collectors.toList());
		this.planetaryBodies = new TreeSet<>(planetList);
		if (starSystem.getPlanetaryBodies().size() != planetaryBodies.size()) {
			System.err.println("!!! Conversion failure - size difference from starSystem planetary body size");
		}
	}

	public Set<Star> getStars() {
		return stars;
	}

	public Set<PlanetaryBodyDefinition> getPlanetaryBodies() {
		return planetaryBodies;
	}
}
