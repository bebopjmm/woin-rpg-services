package com.rpgcampaigner.woin.starSystem.domain;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;

import com.rpgcampaigner.woin.core.universe.PlanetaryBody;
import com.rpgcampaigner.woin.core.universe.PlanetaryType;
import com.rpgcampaigner.woin.core.universe.RockyPlanet;
import com.rpgcampaigner.woin.core.universe.SpectralType;
import com.rpgcampaigner.woin.core.universe.Star;
import com.rpgcampaigner.woin.core.universe.StarSize;
import com.rpgcampaigner.woin.core.universe.StarSystem;

/**
 * @author jmccormick
 * @since 5/16/17
 */
public class StarSystemGenerator {

	Function<Integer, Float> auDistance = i -> {
		switch (i) {
			case 1:
				return 10.0f/350.0f;
			case 2:
				return 25.0f/350.0f;
			case 3:
				return 50.0f/350.0f;
			case 4:
				return 100.0f/350.0f;
			case 5:
				return 200.0f/350.0f;
			case 6:
				return 1.0f;
			case 7:
				return 1.2f;
			case 8:
				return 1.5f;
			case 9:
				return 2.0f;
			case 10:
				return 3.0f;
			case 11:
				return 4.0f;
			case 12:
				return 5.0f;
			default:
				return 2500.0f + (i-48)*500.0f;
		}
	};

	public Supplier<Star> randomStar = () -> {
		Star randomStar = new Star();
		switch (rollD66()) {
			case 11:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.A);
				break;
			case 12:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.B);
				break;
			case 13:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.F);
				break;
			case 14:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.D);
				break;
			case 15:
			case 16:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.F);
				break;
			case 21:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.K);
				break;
			case 22:
			case 23:
			case 24:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.G);
				break;
			case 25:
				randomStar.setSize(StarSize.MAIN_SEQUENCE); //?
				randomStar.setSpectralType(SpectralType.C);
				break;
			case 26:
				randomStar.setSize(StarSize.GIANT);
				randomStar.setSpectralType(SpectralType.M);
				break;
			case 31:
			case 32:
			case 33:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.K);
				break;
			case 34:
				randomStar.setSize(StarSize.GIANT);
				randomStar.setSpectralType(SpectralType.S);
				break;
			case 35:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.M);
				break;
			case 36:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.L);
				break;
			case 41:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.F);
				break;
			case 42:
			case 43:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Y);
				break;
			case 44:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.T);
				break;
			case 45:
			case 46:
				randomStar.setSize(StarSize.GIANT);
				randomStar.setSpectralType(SpectralType.O);
				break;
			case 51:
			case 52:
				randomStar.setSize(StarSize.SUPER_GIANT);
				randomStar.setSpectralType(SpectralType.L);
				break;
			case 53:
			case 54:
				randomStar.setSize(StarSize.SUB_GIANT);
				randomStar.setSpectralType(SpectralType.O);
				break;
			case 55:
			case 56:
				randomStar.setSize(StarSize.SUPER_GIANT);
				randomStar.setSpectralType(SpectralType.W);
				break;
			case 61:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Xi);
				break;
			case 62:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Xii);
				break;
			case 63:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Xiii);
				break;
			case 64:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Xiv);
				break;
			case 65:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Xv);
				break;
			case 66:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Xvi);
				break;
			default:
				throw new IllegalArgumentException("Invalid d66 value");
		}
		// TODO Name Generation
		randomStar.setName("Procis Aventurn");
		return randomStar;
	};

	public Supplier<StarSystem> randomStarSystem = () -> {
		StarSystem starSystem = new StarSystem();
		// TODO Only supporting single star systems for now
		starSystem.getStars().add(randomStar.get());

		// TODO support exploding dice
		int totalPlanets = rollD6() + rollD6();
		int distanceIndex = 0;
		for(int i=1; i<=totalPlanets; i++) {
			PlanetaryBody planetaryBody = randomPlanetaryBody(i);
			// TODO support exploding dice
			distanceIndex += rollD6();
			planetaryBody.setAuDistance(auDistance.apply(distanceIndex));
		}
		return starSystem;
	};

	PlanetaryBody randomPlanetaryBody(int systemPosition) {
		if (systemPosition < 1) {
			throw new IllegalArgumentException("systemPosition must be positive value");
		}
		// TODO support exploding dice
		int roll = rollD6() + systemPosition;
		PlanetaryBody planetaryBody;
		switch (roll) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				planetaryBody = randomRockyPlanet();
				break;
			case 7:case 11:default:
				planetaryBody = new PlanetaryBody();
				planetaryBody.setPlanetaryType(PlanetaryType.A);
				break;
			case 8:
			case 9:
			case 10:
				planetaryBody = new PlanetaryBody();
				planetaryBody.setPlanetaryType(PlanetaryType.G);
				break;
			case 12:
			case 13:
			case 14:
			case 15:
				planetaryBody = new PlanetaryBody();
				planetaryBody.setPlanetaryType(PlanetaryType.I);
				break;
		}

		return planetaryBody;
	}

	RockyPlanet randomRockyPlanet() {
		RockyPlanet planet = new RockyPlanet();
		int roll = rollD6() +rollD6();
		switch(roll) {
			case 2:
				planet.setPlanetaryType(PlanetaryType.R);
				break;
			case 3:
				planet.setPlanetaryType(PlanetaryType.W);
				break;
			case 4:case 5:
				planet.setPlanetaryType(PlanetaryType.I);
				break;
			case 6:
				planet.setPlanetaryType(PlanetaryType.D);
				break;
			case 7:case 8:
				planet.setPlanetaryType(PlanetaryType.B);
				break;
			case 9:
				planet.setPlanetaryType(PlanetaryType.V);
				break;
			case 10:
				planet.setPlanetaryType(PlanetaryType.S);
				break;
			case 11:
				planet.setPlanetaryType(PlanetaryType.J);
				break;
			case 12:
				planet.setPlanetaryType(PlanetaryType.M);
		}
		return planet;
	}

	int rollD6() {
		return ThreadLocalRandom.current().nextInt(1, 7);
	}

	int rollD66() {
		return rollD6() * 10 + rollD6();
	}


}
