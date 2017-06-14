package com.rpgcampaigner.woin.core.universe;

/**
 * @author jmccormick
 * @since 5/18/17
 */
public enum AtmosphereDensity {
	NONE (-5),
	THIN (-2),
	EARTH_LIKE (0),
	THICK (-2),
	CRUSHING (-4);

	int habitablityMod;

	AtmosphereDensity(int habitabilityMod) {
		this.habitablityMod = habitabilityMod;
	}

	public int getHabitablityMod() {
		return habitablityMod;
	}
}
