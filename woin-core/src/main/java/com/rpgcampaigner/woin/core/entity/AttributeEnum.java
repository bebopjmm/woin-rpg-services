package com.rpgcampaigner.woin.core.entity;

/**
 * @author jmccormick
 * @since 2/21/17
 */
public enum AttributeEnum {
	STR("Strength"),
	AGI("Agility"),
	END("Endurance"),
	INT("Intuition"),
	LOG("Logic"),
	WIL("Willpower"),
	CHA("Charisma"),
	LUC("Luck"),
	REP("Reputation"),
	PSI("Psionics");


	private final String longName;

	AttributeEnum(final String longName) {
		this.longName = longName;
	}
}
