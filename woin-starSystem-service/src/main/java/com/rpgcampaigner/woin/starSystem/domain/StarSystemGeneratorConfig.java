package com.rpgcampaigner.woin.starSystem.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jmccormick
 * @since 5/17/17
 */
public class StarSystemGeneratorConfig {

	private Map<Integer, Float> auDistanceMap = new HashMap<>();

	private float auDistanceIncrement;

	public Map<Integer, Float> getAuDistanceMap() {
		return auDistanceMap;
	}

	public void setAuDistanceMap(Map<Integer, Float> auDistanceMap) {
		this.auDistanceMap = auDistanceMap;
	}

	public int maxAuDistanceIndex() {
		return Collections.max(auDistanceMap.keySet());
	}

	public float getAuDistanceIncrement() {
		return auDistanceIncrement;
	}

	public void setAuDistanceIncrement(float auDistanceIncrement) {
		this.auDistanceIncrement = auDistanceIncrement;
	}
}
