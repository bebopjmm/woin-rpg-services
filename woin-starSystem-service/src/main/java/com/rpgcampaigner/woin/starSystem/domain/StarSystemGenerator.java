package com.rpgcampaigner.woin.starSystem.domain;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import com.rpgcampaigner.woin.core.Dice;
import com.rpgcampaigner.woin.core.universe.AtmosphereDensity;
import com.rpgcampaigner.woin.core.universe.PlanetaryBody;
import com.rpgcampaigner.woin.core.universe.PlanetarySize;
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
	private StarSystemGeneratorConfig config;

	public StarSystemGenerator(StarSystemGeneratorConfig config) {
		this.config = config;
	}

	Function<Integer, Float> auDistance = i -> {
		if (i < 1) {
			throw new IllegalArgumentException("auDistance input value must be a positive integer");
		}
		int maxIndex = config.maxAuDistanceIndex();
		if (i > maxIndex) {
			int delta = i - maxIndex;
			return config.getAuDistanceMap().get(maxIndex) + delta * config.getAuDistanceIncrement();
		}
		return config.getAuDistanceMap().get(i);
	};

	Function<Integer, AtmosphereDensity> atmosphereDensityFunction = i -> {
		if (i < config.minAtmosphereDensityIndex()) {
			i = config.minAtmosphereDensityIndex();
		}
		if (i > config.maxAtmosphereDensityIndex()) {
			i = config.maxAtmosphereDensityIndex();
		}
		return AtmosphereDensity.valueOf(config.getAtmosphereDensity().get(i));
	};

	public Supplier<Star> randomStar = () -> {
		Star randomStar = new Star();
		// Generate a name
		StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(config.getStarNamesPt1().get(Dice.rollD66()) + " ");
		switch (Dice.rollD6()) {
			case 1:
			case 2:
				nameBuilder.append(config.getStarNamesPt2a().get(Dice.rollD66()));
				break;
			case 3:
			case 4:
				nameBuilder.append(config.getStarNamesPt2b().get(Dice.rollD66()));
				break;
			case 5:
			case 6:
				nameBuilder.append(config.getStarNamesPt2c().get(Dice.rollD66()));
		}

		// Generate size and luminosity
		randomStar.setName(nameBuilder.toString());
		switch (Dice.rollD66()) {
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

		return randomStar;
	};

	public Supplier<StarSystem> randomStarSystem = () -> {
		StarSystem starSystem = new StarSystem();
		// TODO Only supporting single star systems for now
		Star star = randomStar.get();
		String stellarCode = star.getSpectralType().name();
		starSystem.getStars().add(star);

		int totalPlanets = Dice.rollExplodingD6() + Dice.rollExplodingD6();
		int distanceIndex = 0;
		for (int i = 1; i <= totalPlanets; i++) {
			PlanetaryBody planetaryBody = randomPlanetaryBody(i);
			planetaryBody.setStellarCode(stellarCode + i);
			distanceIndex += Dice.rollD6();
			planetaryBody.setAuDistance(auDistance.apply(distanceIndex));

			starSystem.getPlanetaryBodies().add(planetaryBody);
		}
		return starSystem;
	};

	PlanetaryBody randomPlanetaryBody(int systemPosition) {
		if (systemPosition < 1) {
			throw new IllegalArgumentException("systemPosition must be positive value");
		}
		int roll = Dice.rollExplodingD6() + systemPosition;
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
			case 7:
			case 11:
			default:
				planetaryBody = new PlanetaryBody();
				planetaryBody.setType(PlanetaryType.A);
				break;
			case 8:
			case 9:
			case 10:
				planetaryBody = new PlanetaryBody();
				planetaryBody.setType(PlanetaryType.G);
				generateSizeBasedAttributes(planetaryBody, PlanetarySize.g);
				generateAtmosphereAttributes(planetaryBody);
				break;
			case 12:
			case 13:
			case 14:
			case 15:
				planetaryBody = new PlanetaryBody();
				planetaryBody.setType(PlanetaryType.I);
				generateSizeBasedAttributes(planetaryBody, PlanetarySize.g);
				generateAtmosphereAttributes(planetaryBody);
				break;
		}
		return planetaryBody;
	}

	RockyPlanet randomRockyPlanet() {
		RockyPlanet planet = new RockyPlanet();
		planet.setType(PlanetaryType.valueOf(config.getRockyPlanetType().get(Dice.rollD6() + Dice.rollD6())));
		generateSizeBasedAttributes(planet, PlanetarySize.valueOf(config.getRockyPlanetSize().get(Dice.rollD6())));
		generateAtmosphereAttributes(planet);
		return planet;
	}

	private void generateSizeBasedAttributes(PlanetaryBody planetaryBody, PlanetarySize size) {
		Objects.requireNonNull(planetaryBody);
		Objects.requireNonNull(size);
		planetaryBody.setSize(Optional.of(size));
		planetaryBody.setRadiusKm(size.generateRadius());
		planetaryBody.setGravity(size.generateGravity());
		planetaryBody.setRotationHrs(size.generateRotationHrs());
		planetaryBody.setHasRings(size.generateHasRings());
	}

	private void generateAtmosphereAttributes(PlanetaryBody planetaryBody) {
		int gravityMod = 0;
		if (planetaryBody.getGravity() >= 1.6)
			gravityMod += 2;
		if (planetaryBody.getGravity() <= 0.6) {
			gravityMod -= 2;
		}
		planetaryBody.setAtmosphereDensity(atmosphereDensityFunction
				.apply(planetaryBody.getType().generateAtmosphereDensityValue() + gravityMod));
	}

}
