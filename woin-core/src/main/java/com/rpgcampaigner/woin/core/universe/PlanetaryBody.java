package com.rpgcampaigner.woin.core.universe;

import java.util.Optional;
import java.util.Set;

/**
 * @author jmccormick
 * @since 5/16/17
 */
public class PlanetaryBody implements Comparable<PlanetaryBody>{
	private float auDistance;
	private String stellarCode;
	private PlanetaryType type;
	private int position;
	private int radiusKm;
	private float gravity;
	private int rotationHrs;
	private boolean hasRings;
	private int habitabilityRating = 10;
	private Optional<Atmosphere> atmosphere = Optional.empty();
	private Optional<PlanetarySize> size = Optional.empty();
	private Optional<String> name = Optional.empty();
	private Set<PlanetaryBody> moons;

	public String getCategoryCode() {
		StringBuilder code = new StringBuilder();
		code.append(stellarCode + "-");
		size.ifPresent(size -> code.append(size.name()));
		code.append(position + type.name());
		return code.toString();
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getStellarCode() {
		return stellarCode;
	}

	public void setStellarCode(String stellarCode) {
		this.stellarCode = stellarCode;
	}

	public PlanetaryType getType() {
		return type;
	}

	public void setType(PlanetaryType type) {
		this.type = type;
	}

	public float getAuDistance() {
		return auDistance;
	}

	public void setAuDistance(float auDistance) {
		this.auDistance = auDistance;
	}

	public int getRadiusKm() {
		return radiusKm;
	}

	public void setRadiusKm(int radiusKm) {
		this.radiusKm = radiusKm;
	}

	public float getGravity() {
		return gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public int getRotationHrs() {
		return rotationHrs;
	}

	public void setRotationHrs(int rotationHrs) {
		this.rotationHrs = rotationHrs;
	}

	public boolean hasRings() {
		return hasRings;
	}

	public void setHasRings(boolean hasRings) {
		this.hasRings = hasRings;
	}

	public Set<PlanetaryBody> getMoons() {
		return moons;
	}

	public Optional<PlanetarySize> getSize() {
		return size;
	}

	public void setSize(Optional<PlanetarySize> size) {
		this.size = size;
	}

	public int getHabitabilityRating() {
		return habitabilityRating;
	}

	public void setHabitabilityRating(int habitabilityRating) {
		this.habitabilityRating = habitabilityRating;
	}

	public Optional<Atmosphere> getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(Optional<Atmosphere> atmosphere) {
		this.atmosphere = atmosphere;
	}

	@Override
	public int compareTo(PlanetaryBody o) {
		return (int)(this.auDistance - o.auDistance);
	}
}
