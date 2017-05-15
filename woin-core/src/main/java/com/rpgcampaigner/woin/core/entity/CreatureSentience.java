package com.rpgcampaigner.woin.core.entity;

import java.util.function.Function;

/**
 * @author jmccormick
 * @since 3/28/17
 */
public enum CreatureSentience {
	NON_SENTIENT,
	SEMI_SENTIENT,
	SENTIENT,
	SUPER_SENTIENT;

	Function<CreatureSentience, Integer> defaultIntuition = sentience -> {
		switch (sentience) {
			case NON_SENTIENT:
				return 0;
			case SEMI_SENTIENT: SENTIENT:
				return 10;
			case SUPER_SENTIENT:
				return 20;
				default:
					throw new IllegalArgumentException("Unsupported CreatureSentience: " + sentience.name());
		}
	};

	Function<CreatureSentience, Integer> defaultLogic = sentience -> {
		switch (sentience) {
			case NON_SENTIENT:
				return 0;
			case SEMI_SENTIENT:
				return 2;
			case SENTIENT:
				return 10;
			case SUPER_SENTIENT:
				return 20;
			default:
				throw new IllegalArgumentException("Unsupported CreatureSentience: " + sentience.name());
		}
	};
}
