package com.rpgcampaigner.woin.core.universe;

import java.util.function.Supplier;

import com.rpgcampaigner.woin.core.Dice;

/**
 * @author jmccormick
 * @since 5/16/17
 */
public enum PlanetaryType {
	A("asteroid/planetoid belt", false, -10,
			() -> 0),
	G("gas", false, -5,
			() -> Dice.rollD6() + Dice.rollD6() + Dice.rollD6() + 5),
	I("icy", true, -2,
			() -> Dice.rollD6() + Dice.rollD6() + Dice.rollD6()),
	R("ruined", true, -1,
			() -> Dice.rollD6() + Dice.rollD6() + Dice.rollD6()),
	W("water", true, -1,
			() -> Dice.rollD6() + Dice.rollD6() + 3),
	D("desert", true, -2,
			() -> Dice.rollD6() + Dice.rollD6() + 3),
	B("barren", true, -2,
			() -> Dice.rollD6() + Dice.rollD6()),
	V("volcanic", true, -3,
			() -> Dice.rollD6() + Dice.rollD6() + Dice.rollD6()),
	S("swamp", true, -1,
			() -> Dice.rollD6() + Dice.rollD6() + 5),
	J("jungle", true, -1,
			() -> Dice.rollD6() + Dice.rollD6() + 5),
	M("terrestrial/mixed", true, 0,
			() -> Dice.rollD6() + Dice.rollD6() + 3);

	String description;
	boolean isRocky;
	int habitabilityMod;
	Supplier<Integer> atmosphereDensitySupplier;

	PlanetaryType(String description, boolean isRocky, int habitabilityMod, Supplier<Integer>
			atmosphereDensitySupplier) {
		this.description = description;
		this.isRocky = isRocky;
		this.atmosphereDensitySupplier = atmosphereDensitySupplier;
	}

	public String getDescription() {
		return description;
	}

	public boolean isRocky() {
		return isRocky;
	}

	public int getHabitabilityMod() {
		return habitabilityMod;
	}

	public int generateAtmosphereDensityValue() {
		return atmosphereDensitySupplier.get();
	}
}
