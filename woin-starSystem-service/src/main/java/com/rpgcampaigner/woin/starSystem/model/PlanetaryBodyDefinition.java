package com.rpgcampaigner.woin.starSystem.model;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import com.rpgcampaigner.woin.core.universe.PlanetaryBody;

import io.advantageous.qbit.annotation.JsonIgnore;

/**
 * @author jmccormick
 * @since 5/18/17
 */
public class PlanetaryBodyDefinition implements Comparable<PlanetaryBodyDefinition> {
	private UUID uuid;
	private float auDistance;
	@JsonIgnore
	private Optional<Integer> orbitalIndex = Optional.empty();
	private String categoryCode;
	private String type;
	private String size = "N/A";
	private int radiusKm;
	private float gravity;
	private int rotationHrs;
	private boolean hasRings;
	private String atmosphere = "None";
	private String composition = "--";
	private int habitabilityRating = 10;
	private Set<PlanetaryBodyDefinition> satellites = new TreeSet<>();

	public PlanetaryBodyDefinition(PlanetaryBody planetaryBody) {
		this.uuid = planetaryBody.getUuid();
		this.categoryCode = planetaryBody.buildCategoryCode();
		this.auDistance = planetaryBody.getAuDistance();
		this.orbitalIndex = planetaryBody.getOrbitalIndex();
		this.type = planetaryBody.getType().getDescription();
		this.radiusKm = planetaryBody.getRadiusKm();
		this.gravity = planetaryBody.getGravity();
		this.rotationHrs = planetaryBody.getRotationHrs();
		this.hasRings = planetaryBody.hasRings();
		this.habitabilityRating = planetaryBody.getHabitabilityRating();
		planetaryBody.getSize().ifPresent(size -> this.size = size.getDescription());
		planetaryBody.getAtmosphere().ifPresent(atmosphere -> {
			this.atmosphere = atmosphere.getDensity().name();
			this.composition = atmosphere.getPrimaryComposition().name() + "(" +
					atmosphere.getTraceComposition().name() + ")";
		});
		planetaryBody.getMoons().stream().forEach(moon -> {
			boolean added = this.satellites.add(new PlanetaryBodyDefinition(moon));
			if (!added) {
				System.err.println("!!! Failed to convert moon to definition, " + moon.buildCategoryCode());
			}
		});
	}

	public float getAuDistance() {
		return auDistance;
	}

	public void setAuDistance(float auDistance) {
		this.auDistance = auDistance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public boolean isHasRings() {
		return hasRings;
	}

	public void setHasRings(boolean hasRings) {
		this.hasRings = hasRings;
	}

	public int getHabitabilityRating() {
		return habitabilityRating;
	}

	public void setHabitabilityRating(int habitabilityRating) {
		this.habitabilityRating = habitabilityRating;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(String atmosphere) {
		this.atmosphere = atmosphere;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	@Override
	public int compareTo(PlanetaryBodyDefinition o) {
		float auComparison = this.auDistance - o.auDistance;
		if ((auComparison == 0.0f) && this.orbitalIndex.isPresent() && o.orbitalIndex.isPresent()) {
			return this.orbitalIndex.get() - o.orbitalIndex.get();
		}
		if (auComparison < 0.0f) {
			return -1;
		} else if (auComparison > 0.0f) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PlanetaryBodyDefinition)) {
			return false;
		}
		PlanetaryBodyDefinition other = (PlanetaryBodyDefinition) obj;
		return this.uuid == other.uuid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid);
	}
}
