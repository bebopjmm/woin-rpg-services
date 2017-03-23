package com.rpgcampaigner.woin.characterReference.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jmccormick
 * @since 3/23/17
 */
public class SkillGroupUpdateDefinition {
	private Set<String> addSkills = new HashSet<>();

	private Set<String> removeSkills = new HashSet<>();

	public Set<String> getAddSkills() {
		return addSkills;
	}

	public Set<String> getRemoveSkills() {
		return removeSkills;
	}
}
