package com.rpgcampaigner.woin.entityReference.dal;

import java.util.Optional;
import java.util.Set;

import com.rpgcampaigner.woin.core.entity.Skill;
import com.rpgcampaigner.woin.core.entity.SkillGroup;

/**
 * @author jmccormick
 * @since 6/14/17
 */
public interface ReferenceRepository {
	Set<SkillGroup> getAllSkillGroups();

	Optional<SkillGroup> getSkillGroup(String name);

	void createSkillGroup(SkillGroup skillGroup);

	void updateSkillGroup(SkillGroup skillGroup);
}
