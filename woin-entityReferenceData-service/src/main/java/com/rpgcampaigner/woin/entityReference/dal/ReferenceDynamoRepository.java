package com.rpgcampaigner.woin.entityReference.dal;

import java.util.Set;

import com.amazonaws.services.dynamodbv2.document.Table;
import com.rpgcampaigner.woin.core.entity.Skill;
import com.rpgcampaigner.woin.core.entity.SkillGroup;

/**
 * @author jmccormick
 * @since 6/14/17
 */
public class ReferenceDynamoRepository implements ReferenceRepository {

	private final Table referenceTable;

	public ReferenceDynamoRepository(Table referenceTable) {
		this.referenceTable = referenceTable;
	}

	@Override
	public Set<SkillGroup> getAllSkillGroups() {
		return null;
	}

	@Override
	public SkillGroup getSkillGroup(String name) {
		return null;
	}

	@Override
	public Set<Skill> getAllSkills() {
		return null;
	}

	@Override
	public Skill getSkill(String skillName) {
		return null;
	}

	@Override
	public void createSkill(Skill skill) {

	}

	@Override
	public void createSkillGroup(SkillGroup skillGroup) {

	}

	@Override
	public void updateSkillGroup(SkillGroup skillGroup) {

	}
}
