package com.rpgcampaigner.woin.core.universe;

import java.util.function.Supplier;

import com.rpgcampaigner.woin.core.Dice;

/**
 * @author jmccormick
 * @since 5/16/17
 */
public enum PlanetarySize {
	o("orbital", 0,
			() -> 0,
			() -> 0.0f,
			() -> 0,
			() -> 0),
	d("dwarf", 0,
			() -> (Dice.rollD6() + Dice.rollD6() + Dice.rollD6()) * 100,
			() -> Dice.rollD6() * 0.1f,
			() -> {
				int sum = 0;
				for (int i = 0; i < 6; i++) {
					sum += Dice.rollD6();
				}
				return sum * 10;
			},
			() -> Dice.rollD6() - 4),
	s("small", 0,
			() -> Dice.rollD6() * 1000,
			() -> (Dice.rollD6() + Dice.rollD6()) * 0.1f,
			() -> {
				int sum = 0;
				for (int i = 0; i < 6; i++) {
					sum += Dice.rollD6();
				}
				return sum * 2;
			},
			() -> Dice.rollD6() - 4),
	m("medium", 1,
			() -> (Dice.rollD6()+4) * 1000,
			() -> (Dice.rollD6() + Dice.rollD6() + Dice.rollD6()) * 0.1f,
			() -> {
				int sum = 0;
				for (int i = 0; i < 6; i++) {
					sum += Dice.rollD6();
				}
				return sum;
			},
			() -> Dice.rollD6() - 3),
	l("large", 3,
			() -> Dice.rollD6() * 10000,
			() -> {
				int sum = 0;
				for (int i = 0; i < 6; i++) {
					sum += Dice.rollD6();
				}
				return sum * 0.1f;
			},
			() -> {
				int sum = 0;
				for (int i = 0; i < 4; i++) {
					sum += Dice.rollD6();
				}
				return sum;
			},
			() -> Dice.rollD6()),
	g("giant", 4,
			() -> (Dice.rollD6()+4) * 10000,
			() -> {
				int sum = 0;
				for (int i = 0; i < 10; i++) {
					sum += Dice.rollD6();
				}
				return sum * 0.1f;
			},
			() -> {
				int sum = 0;
				for (int i = 0; i < 3; i++) {
					sum += Dice.rollD6();
				}
				return sum;
			},
			() -> {
				int moons = 0;
				for (int i = 0; i < 6; i++) {
					moons += Dice.rollExplodingD6();
				}
				return moons;
			});

	String description;
	int ringsThreshold;
	Supplier<Integer> radiusSupplier;
	Supplier<Float> gravitySupplier;
	Supplier<Integer> rotationSupplier;
	Supplier<Integer> numberMoonsSupplier;


	PlanetarySize(
			String description,
			int ringsThreshold,
			Supplier<Integer> radiusSupplier,
			Supplier<Float> gravitySupplier,
			Supplier<Integer> rotationSupplier,
			Supplier<Integer> numberMoonsSupplier) {
		this.description = description;
		this.ringsThreshold = ringsThreshold;
		this.radiusSupplier = radiusSupplier;
		this.gravitySupplier = gravitySupplier;
		this.rotationSupplier = rotationSupplier;
		this.numberMoonsSupplier = numberMoonsSupplier;
	}

	public String getDescription() {
		return description;
	}

	public int generateRadius() {
		return radiusSupplier.get();
	}

	public float generateGravity() {
		return gravitySupplier.get();
	}

	public int generateRotationHrs() {
		return rotationSupplier.get();
	}

	public int generateNumberOfMoons() {
		return numberMoonsSupplier.get();
	}

	public boolean generateHasRings() {
		return Dice.rollD6() <= ringsThreshold;
	}
}
