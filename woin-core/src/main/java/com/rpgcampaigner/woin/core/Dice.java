package com.rpgcampaigner.woin.core;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author jmccormick
 * @since 5/17/17
 */
public class Dice {

	public static int rollD6() {
		return ThreadLocalRandom.current().nextInt(1, 7);
	}

	public static int rollD66() {
		return rollD6() * 10 + rollD6();
	}

	public static int rollExplodingD6() {
		int roll = rollD6();
		int result = roll;
		while (roll == 6) {
			roll = rollD6();
			result += roll;
		}
		return result;
	}
}
