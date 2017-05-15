package com.rpgcampaigner.woin.entityReference.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jmccormick
 * @since 3/27/17
 */
public class SkillGroupCreateDefinition extends NamedDefinition {
	private Set<String> skills = new HashSet<>();

	public Set<String> getSkills() {
		return skills;
	}
}
