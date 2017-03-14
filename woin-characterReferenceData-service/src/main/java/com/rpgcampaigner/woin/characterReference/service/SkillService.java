package com.rpgcampaigner.woin.characterReference.service;

import java.util.HashSet;
import java.util.Set;

import com.rpgcampaigner.woin.core.entity.SkillGroup;

import io.advantageous.qbit.annotation.RequestMapping;
import io.advantageous.qbit.annotation.RequestMethod;

/**
 * @author jmccormick
 * @since 3/14/17
 */
@RequestMapping(value = "/woin/characterReference/skills")
public class SkillService {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Set<SkillGroup> getAllSkillGroups() {
		Set<SkillGroup> results = new HashSet<>();

		// TODO lookup current SkillGroups

		return results;
	}
}
