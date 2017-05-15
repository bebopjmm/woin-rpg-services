package com.rpgcampaigner.woin.core.entity;

import java.util.function.Function;

/**
 * @author jmccormick
 * @since 2/24/17
 */
public enum CreatureSize {
	TINY,
	SMALL,
	MEDIUM,
	LARGE,
	ENORMOUS,
	GIGANTIC,
	COLOSSAL,
	TITANIC;

	Function<CreatureSize, Integer> defaultStrength = size -> {
		switch (size) {
			case TINY:
				return 1;
			case SMALL:
				return 3;
			case MEDIUM:
				return 6;
			case LARGE:
				return 10;
			case ENORMOUS:
				return 20;
			case GIGANTIC:
				return 50;
			case COLOSSAL:
				return 80;
			case TITANIC:
				return 120;
				default:
					throw new IllegalArgumentException("Unsupported CreatureSize: " + size.name());
		}
	};

	Function<CreatureSize, Integer> defaultAgility = size -> {
		switch (size) {
			case TINY:
				return 20;
			case SMALL:
				return 10;
			case MEDIUM:
				return 6;
			case LARGE: ENORMOUS: GIGANTIC: COLOSSAL: TITANIC:
				return 4;
			default:
				throw new IllegalArgumentException("Unsupported CreatureSize: " + size.name());
		}
	};

	Function<CreatureSize, Integer> defaultEndurance = size -> {
		switch (size) {
			case TINY:
				return 1;
			case SMALL:
				return 3;
			case MEDIUM:
				return 6;
			case LARGE:
				return 10;
			case ENORMOUS:
				return 25;
			case GIGANTIC:
				return 60;
			case COLOSSAL:
				return 100;
			case TITANIC:
				return 200;
			default:
				throw new IllegalArgumentException("Unsupported CreatureSize: " + size.name());
		}
	};
}
