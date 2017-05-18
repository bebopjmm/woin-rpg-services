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

	private Map<Integer, String> starNamesPt1 = new HashMap<>();

	private Map<Integer, String> starNamesPt2a = new HashMap<>();

	private Map<Integer, String> starNamesPt2b = new HashMap<>();

	private Map<Integer, String> starNamesPt2c = new HashMap<>();

	private Map<Integer, String> rockyPlanetType = new HashMap<>();

	private Map<Integer, String> rockyPlanetSize = new HashMap<>();


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

	public Map<Integer, String> getStarNamesPt1() {
		return starNamesPt1;
	}

	public void setStarNamesPt1(Map<Integer, String> starNamesPt1) {
		this.starNamesPt1 = starNamesPt1;
	}

	public Map<Integer, String> getStarNamesPt2a() {
		return starNamesPt2a;
	}

	public void setStarNamesPt2a(Map<Integer, String> starNamesPt2a) {
		this.starNamesPt2a = starNamesPt2a;
	}

	public Map<Integer, String> getStarNamesPt2b() {
		return starNamesPt2b;
	}

	public void setStarNamesPt2b(Map<Integer, String> starNamesPt2b) {
		this.starNamesPt2b = starNamesPt2b;
	}

	public Map<Integer, String> getStarNamesPt2c() {
		return starNamesPt2c;
	}

	public void setStarNamesPt2c(Map<Integer, String> starNamesPt2c) {
		this.starNamesPt2c = starNamesPt2c;
	}

	public Map<Integer, String> getRockyPlanetType() {
		return rockyPlanetType;
	}

	public void setRockyPlanetType(Map<Integer, String> rockyPlanetType) {
		this.rockyPlanetType = rockyPlanetType;
	}

	public Map<Integer, String> getRockyPlanetSize() {
		return rockyPlanetSize;
	}

	public void setRockyPlanetSize(Map<Integer, String> rockyPlanetSize) {
		this.rockyPlanetSize = rockyPlanetSize;
	}
}
