package com.rpgcampaigner.woin.characterReference.service;

import java.util.Optional;
import java.util.Set;

import com.rpgcampaigner.woin.characterReference.dal.ReferenceRepository;
import com.rpgcampaigner.woin.characterReference.domain.ReferenceManager;
import com.rpgcampaigner.woin.characterReference.model.NamedDefinition;
import com.rpgcampaigner.woin.core.entity.Skill;
import com.rpgcampaigner.woin.core.entity.SkillGroup;

import io.advantageous.qbit.annotation.PathVariable;
import io.advantageous.qbit.annotation.RequestMapping;
import io.advantageous.qbit.annotation.RequestMethod;

/**
 * @author jmccormick
 * @since 3/14/17
 */
@RequestMapping("/woin/characterReference/skills")
public class SkillService {

	private ReferenceManager referenceManager;

	private ReferenceRepository referenceRepository;

	public SkillService(ReferenceManager referenceManager, ReferenceRepository referenceRepository) {
		this.referenceManager = referenceManager;
		this.referenceRepository = referenceRepository;
	}

	/*************************************
	 * SKILL SERVICE CALLS
	 *************************************/

	/**
	 * @param definition
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Skill createSkill(final NamedDefinition definition) {
		Skill skill = new Skill(definition.getName());
		referenceRepository.createSkill(skill);
		return skill;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Set<Skill> getAllSkills() {
		return referenceRepository.getAllSkills();
	}

	@RequestMapping(value = "/{skillName}", method = RequestMethod.GET)
	public Skill getSkill(@PathVariable("skillName") String name) {
		Skill result = Optional.ofNullable(referenceRepository.getSkill(name))
				.orElseThrow(() -> new IllegalArgumentException("Skill does not exist: " + name));
		System.out.println ("Found skill with name = " + result.getName());
		return result;
	}

	/*************************************
	 * SKILLGROUP SERVICE CALLS
	 *************************************/

	/**
	 * @param definition
	 * @return
	 */
	@RequestMapping(value = "/groups/", method = RequestMethod.POST)
	public SkillGroup createSkillGroup(final NamedDefinition definition) {
		SkillGroup skillGroup = new SkillGroup(definition.getName());
		referenceRepository.createSkillGroup(skillGroup);
		return skillGroup;
	}

	@RequestMapping(value = "/groups/", method = RequestMethod.GET)
	public Set<SkillGroup> getAllSkillGroups() {
		return referenceRepository.getAllSkillGroups();
	}

	@RequestMapping(value = "/groups/{name}", method = RequestMethod.GET)
	public SkillGroup getSkillGroup(@PathVariable("name") String name) {
		SkillGroup result = Optional.ofNullable(referenceRepository.getSkillGroup(name))
				.orElseThrow(() -> new IllegalArgumentException("SkillGroup does not exist: " + name));
		System.out.println ("Found skillGroup with name = " + result.getName());
		return result;
	}

	// TODO add a skill to a skillGroup


	// TODO remove a skill from a skillGroup
}
