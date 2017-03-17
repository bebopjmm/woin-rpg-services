package com.rpgcampaigner.woin.characterReference.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.rpgcampaigner.woin.characterReference.dal.ReferenceRepository;
import com.rpgcampaigner.woin.core.entity.Skill;
import com.rpgcampaigner.woin.core.entity.SkillGroup;

/**
 * @author jmccormick
 * @since 3/17/17
 */
public class ReferenceManager {

	private ReferenceRepository repository;

	public ReferenceManager(final ReferenceRepository referenceRepository) {
		this.repository = referenceRepository;
	}

	public Set<SkillGroup> getSkillGroups() {
		repository.getSkillGroups();
		// FIXME this will go away once repo hookup complete
		return skillGroups;
	}

	public void addSkill(Skill skill) {
		repository.addSkill(skill);
	}

	public void addSkillGroup(SkillGroup skillGroup) {
		repository.addSkillGroup(skillGroup);
	}

	static Set<SkillGroup> skillGroups = new HashSet<>();

	static {
		SkillGroup sample = new SkillGroup("Academic");
		skillGroups.add(sample);
		Skill skill = new Skill("literature");
		sample.getSkillSet().add(skill);
	}
}
