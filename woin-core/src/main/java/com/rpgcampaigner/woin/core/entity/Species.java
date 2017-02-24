package com.rpgcampaigner.woin.core.entity;

import java.util.Set;
import java.util.UUID;

import com.rpgcampaigner.woin.core.Modifier;

/**
 * @author jmccormick
 * @since 2/24/17
 */
public class Species {

	private UUID id;

	private String name;

	private Set<CreatureSize> sizeOptions;

	private Set<Modifier> attributeModifiers;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CreatureSize> getSizeOptions() {
		return sizeOptions;
	}

	public void setSizeOptions(Set<CreatureSize> sizeOptions) {
		this.sizeOptions = sizeOptions;
	}

	public Set<Modifier> getAttributeModifiers() {
		return attributeModifiers;
	}

	public void setAttributeModifiers(Set<Modifier> attributeModifiers) {
		this.attributeModifiers = attributeModifiers;
	}
}
