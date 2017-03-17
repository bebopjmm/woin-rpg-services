package com.rpgcampaigner.woin.characterReference.dal;

import java.util.Collections;
import java.util.Set;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.rpgcampaigner.woin.core.entity.Skill;
import com.rpgcampaigner.woin.core.entity.SkillGroup;

/**
 * @author jmccormick
 * @since 3/17/17
 */
public class ReferenceRepository {

	private Bucket referenceBucket;

	public ReferenceRepository(Bucket referenceBucket) {
		this.referenceBucket = referenceBucket;
	}

	public Set<SkillGroup> getSkillGroups() {
		return Collections.emptySet();
	}

	public void addSkill(Skill skill) {
		JsonObject skillData = JsonObject.create()
				.put("type", "skill")
				.put("name", skill.getName());
		JsonDocument doc = JsonDocument.create(skill.getId().toString(), skillData);
		referenceBucket.insert(doc);
	}

	public void addSkillGroup(SkillGroup skillGroup) {
		JsonObject skillGroupData = JsonObject.create()
				.put("type", "skillGroup")
				.put("name", skillGroup.getName());
		JsonDocument doc = JsonDocument.create(skillGroup.getId().toString(), skillGroupData);
		referenceBucket.insert(doc);
	}
}
