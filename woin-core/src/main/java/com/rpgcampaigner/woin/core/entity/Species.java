package com.rpgcampaigner.woin.core.entity;

import java.util.HashSet;
import java.util.Map;
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

	private Set<CreatureSize> sizeOptions = new HashSet<>();

	private Map<AttributeEnum, Modifier> fixedAttributeModifiers;

	private Set<Modifier> selectionAttributeModifiers = new HashSet<>();

	private Set<Skill> skillOptionSet = new HashSet<>();

	private Set<SkillGroup> skillGroupOptionSet = new HashSet<>();

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

	public Set<Skill> getSkillOptionSet() {
		return skillOptionSet;
	}

	public void setSkillOptionSet(Set<Skill> skillOptionSet) {
		this.skillOptionSet = skillOptionSet;
	}

	public Set<SkillGroup> getSkillGroupOptionSet() {
		return skillGroupOptionSet;
	}

	public void setSkillGroupOptionSet(Set<SkillGroup> skillGroupOptionSet) {
		this.skillGroupOptionSet = skillGroupOptionSet;
	}

	public Map<AttributeEnum, Modifier> getFixedAttributeModifiers() {
		return fixedAttributeModifiers;
	}

	public void setFixedAttributeModifiers(Map<AttributeEnum, Modifier> fixedAttributeModifiers) {
		this.fixedAttributeModifiers = fixedAttributeModifiers;
	}

	public Set<Modifier> getSelectionAttributeModifiers() {
		return selectionAttributeModifiers;
	}

	public void setSelectionAttributeModifiers(Set<Modifier> selectionAttributeModifiers) {
		this.selectionAttributeModifiers = selectionAttributeModifiers;
	}
}
