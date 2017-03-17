package com.rpgcampaigner.woin.characterReference.service;

import java.util.Set;

import com.rpgcampaigner.woin.characterReference.domain.ReferenceManager;
import com.rpgcampaigner.woin.characterReference.model.NamedDefinition;
import com.rpgcampaigner.woin.core.entity.Skill;
import com.rpgcampaigner.woin.core.entity.SkillGroup;

import io.advantageous.qbit.annotation.RequestMapping;
import io.advantageous.qbit.annotation.RequestMethod;

/**
 * @author jmccormick
 * @since 3/14/17
 */
@RequestMapping("/woin/characterReference/skills")
public class SkillService {

	private ReferenceManager referenceManager;

	public SkillService(ReferenceManager referenceManager) {
		this.referenceManager = referenceManager;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Set<SkillGroup> getAllSkillGroups() {
		return referenceManager.getSkillGroups();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Skill addSkill(final NamedDefinition definition) {
		Skill skill = new Skill(definition.getName());
		referenceManager.addSkill(skill);
		return skill;
	}

	@RequestMapping(value = "/groups/", method = RequestMethod.POST)
	public SkillGroup addSkillGroup(final NamedDefinition definition) {
		SkillGroup skillGroup = new SkillGroup(definition.getName());
		referenceManager.addSkillGroup(skillGroup);
		return skillGroup;
	}
}
