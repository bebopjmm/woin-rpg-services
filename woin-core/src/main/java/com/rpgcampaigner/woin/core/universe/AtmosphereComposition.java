package com.rpgcampaigner.woin.core.universe;

/**
 * @author jmccormick
 * @since 5/18/17
 */
public enum AtmosphereComposition {
	EARTH_LIKE (0),
	CO2 (-5),
	CH4 (-5),
	He (-5),
	H (-5),
	N (-5),
	CO (-5),
	Ar (-5),
	HCN (-5),
	SO2 (-5),
	NH3 (-5);

	int habitablityMod;


	AtmosphereComposition(int habitablityMod) {
		this.habitablityMod = habitablityMod;
	}

	public int getHabitablityMod() {
		return habitablityMod;
	}
}
