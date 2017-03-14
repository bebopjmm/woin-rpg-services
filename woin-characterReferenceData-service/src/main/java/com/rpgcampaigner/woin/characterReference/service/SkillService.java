package com.rpgcampaigner.woin.characterReference.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.rpgcampaigner.woin.core.entity.Skill;
import com.rpgcampaigner.woin.core.entity.SkillGroup;

import io.advantageous.qbit.annotation.RequestMapping;
import io.advantageous.qbit.annotation.RequestMethod;

/**
 * @author jmccormick
 * @since 3/14/17
 */
@RequestMapping(value = "/woin/characterReference/skills")
public class SkillService {

	static Set<SkillGroup> skillGroups = new HashSet<>();

	static {
		SkillGroup sample = new SkillGroup();
		sample.setId(UUID.randomUUID());
		sample.setName("Academic");
		skillGroups.add(sample);
		Skill skill = new Skill();
		skill.setId(UUID.randomUUID());
		skill.setName("literature");
		sample.getSkillSet().add(skill);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Set<SkillGroup> getAllSkillGroups() {
		Set<SkillGroup> results = new HashSet<>();

		results.addAll(skillGroups);

		// TODO lookup current SkillGroups

		return results;
	}
}
