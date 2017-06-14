package com.rpgcampaigner.woin.entityReference.domain;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import com.rpgcampaigner.woin.entityReference.dal.ReferenceCouchbaseRepository;
import com.rpgcampaigner.woin.core.entity.Skill;
import com.rpgcampaigner.woin.core.entity.SkillGroup;
import com.rpgcampaigner.woin.entityReference.dal.ReferenceRepository;

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
		return repository.getAllSkillGroups();
	}

	public Set<Skill> getSkills() {
		return repository.getAllSkills();
	}

	public Optional<Skill> getSkill(final String skillId) {
		Objects.requireNonNull(skillId);
		return Optional.ofNullable(repository.getSkill(skillId));
	}

	public void createSkill(Skill skill) {
		repository.createSkill(skill);
	}

	public void createSkillGroup(SkillGroup skillGroup) {
		repository.createSkillGroup(skillGroup);
	}

	public SkillGroup addSkillToGroup(final String skillId, final String skillGroupId) {
		Objects.requireNonNull(skillId);
		Objects.requireNonNull(skillGroupId);

		return null;
	}
}
