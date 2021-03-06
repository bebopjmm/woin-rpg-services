package com.rpgcampaigner.woin.core.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SkillGroup is a reference data class that categorizes a set of specific skills. This is most typically used a a
 * convenience aggregation for skill selection options.
 *
 * @author jmccormick
 * @since 3/14/17
 */
public class SkillGroup {

	private String name;

	private Set<Skill> skillSet = new HashSet<>();

	public SkillGroup(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Skill> getSkillSet() {
		return skillSet;
	}

}
