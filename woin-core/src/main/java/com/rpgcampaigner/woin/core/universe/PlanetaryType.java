package com.rpgcampaigner.woin.core.universe;

import java.util.function.Supplier;

import com.rpgcampaigner.woin.core.Dice;

/**
 * @author jmccormick
 * @since 5/16/17
 */
public enum PlanetaryType {
	A("asteroid/planetoid belt", false,
			() -> 0),
	G("gas", false,
			() -> Dice.rollD6() + Dice.rollD6() + Dice.rollD6() + 5),
	I("icy", true,
			() -> Dice.rollD6() + Dice.rollD6() + Dice.rollD6()),
	R("ruined", true,
			() -> Dice.rollD6() + Dice.rollD6() + Dice.rollD6()),
	W("water", true,
			() -> Dice.rollD6() + Dice.rollD6() + 3),
	D("desert", true,
			() -> Dice.rollD6() + Dice.rollD6() + 3),
	B("barren", true,
			() -> Dice.rollD6() + Dice.rollD6()),
	V("volcanic", true,
			() -> Dice.rollD6() + Dice.rollD6() + Dice.rollD6()),
	S("swamp", true,
			() -> Dice.rollD6() + Dice.rollD6() + 5),
	J("jungle", true,
			() -> Dice.rollD6() + Dice.rollD6() + 5),
	M("terrestrial/mixed", true,
			() -> Dice.rollD6() + Dice.rollD6() + 3);

	String description;
	boolean isRocky;
	Supplier<Integer> atmosphereDensitySupplier;

	PlanetaryType(String description, boolean isRocky, Supplier<Integer> atmosphereDensitySupplier) {
		this.description = description;
		this.isRocky = isRocky;
		this.atmosphereDensitySupplier = atmosphereDensitySupplier;
	}

	public int generateAtmosphereDensityValue() {
		return atmosphereDensitySupplier.get();
	}
}
