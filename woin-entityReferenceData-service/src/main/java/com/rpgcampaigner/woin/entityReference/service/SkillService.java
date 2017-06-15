package com.rpgcampaigner.woin.entityReference.service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.rpgcampaigner.woin.core.entity.Skill;
import com.rpgcampaigner.woin.core.entity.SkillGroup;
import com.rpgcampaigner.woin.entityReference.dal.ReferenceRepository;
import com.rpgcampaigner.woin.entityReference.model.NamedDefinition;
import com.rpgcampaigner.woin.entityReference.model.SkillGroupCreateDefinition;
import com.rpgcampaigner.woin.entityReference.model.SkillGroupUpdateDefinition;

import io.advantageous.qbit.annotation.PathVariable;
import io.advantageous.qbit.annotation.RequestMapping;
import io.advantageous.qbit.annotation.RequestMethod;

/**
 * @author jmccormick
 * @since 3/14/17
 */
@RequestMapping("/woin/entityReference/skills")
public class SkillService {

	private ReferenceRepository referenceRepository;

	public SkillService(ReferenceRepository referenceRepository) {
		this.referenceRepository = referenceRepository;
	}

	/*************************************
	 * SKILL SERVICE CALLS
	 *************************************/

//	/**
//	 * @param definition
//	 * @return
//	 */
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public Skill createSkill(final NamedDefinition definition) {
//		return createSkill.apply(definition.getName());
//	}
//
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public Set<Skill> getAllSkills() {
//		return referenceRepository.getAllSkills();
//	}
//
//	@RequestMapping(value = "/{skillName}", method = RequestMethod.GET)
//	public Skill getSkill(@PathVariable("skillName") String name) {
//		Skill result = Optional.ofNullable(referenceRepository.getSkill(name))
//				.orElseThrow(() -> new IllegalArgumentException("Skill does not exist: " + name));
//		System.out.println("Found skill with name = " + result.getName());
//		return result;
//	}
//
//	final Function<String, Skill> createSkill = name -> {
//		Skill skill = new Skill(name);
//		referenceRepository.createSkill(skill);
//		return skill;
//	};

	/*************************************
	 * SKILLGROUP SERVICE CALLS
	 *************************************/

	/**
	 * TODO Support specifying skills that are part of the group and automatically create them as well if they don't
	 * exist
	 *
	 * @param definition
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public SkillGroup createSkillGroup(final SkillGroupCreateDefinition definition) {
		SkillGroup skillGroup = new SkillGroup(definition.getName());
		definition.getSkills().stream()
				.forEach(s -> skillGroup.getSkillSet().add(new Skill(s)));
		referenceRepository.createSkillGroup(skillGroup);
		return skillGroup;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Set<SkillGroup> getAllSkillGroups() {
		return referenceRepository.getAllSkillGroups();
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public SkillGroup getSkillGroup(@PathVariable("name") String name) {
		SkillGroup result = referenceRepository.getSkillGroup(name)
				.orElseThrow(() -> new IllegalArgumentException("SkillGroup does not exist: " + name));
		System.out.println("Found skillGroup with name = " + result.getName());
		return result;
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.PUT)
	public SkillGroup updateSkillGroup(
			@PathVariable("name") String name,
			SkillGroupUpdateDefinition changes) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(changes);

		SkillGroup skillGroup = referenceRepository.getSkillGroup(name)
				.orElseThrow(() -> new IllegalArgumentException("SkillGroup does not exist: " + name));
		Set<Skill> removals = skillGroup.getSkillSet().stream()
				.filter(skill -> changes.getRemoveSkills().contains(skill.getName()))
				.collect(Collectors.toSet());
		skillGroup.getSkillSet().removeAll(removals);
		changes.getAddSkills().stream()
				.forEach(s -> skillGroup.getSkillSet().add(new Skill(s)));
		referenceRepository.updateSkillGroup(skillGroup);
		return skillGroup;
	}
}
