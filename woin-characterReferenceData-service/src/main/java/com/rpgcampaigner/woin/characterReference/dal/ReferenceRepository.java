package com.rpgcampaigner.woin.characterReference.dal;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.rpgcampaigner.woin.core.entity.Skill;
import com.rpgcampaigner.woin.core.entity.SkillGroup;

import static com.couchbase.client.java.query.Select.select;
import static com.couchbase.client.java.query.dsl.Expression.i;
import static com.couchbase.client.java.query.dsl.Expression.s;
import static com.couchbase.client.java.query.dsl.Expression.x;

/**
 * @author jmccormick
 * @since 3/17/17
 */
public class ReferenceRepository {
	private static final String SELECT_ALL = "*";
	private static final String TYPE_SKILLGROUP = "skillGroup";
	private static final String TYPE_SKILL = "skill";
	private static final String FIELD_NAME = "name";

	private Bucket referenceBucket;

	public ReferenceRepository(Bucket referenceBucket) {
		this.referenceBucket = referenceBucket;
	}

	public Set<SkillGroup> getSkillGroups() {
		N1qlQueryResult result = referenceBucket
				.query(select(FIELD_NAME).from(i(referenceBucket.name())).where(x("type").eq(s(TYPE_SKILLGROUP))));
		System.out.println("total results for getSkillGroups = " + result.allRows().size());
		return result.allRows().stream()
				.map(extractToSkillGroup)
				.collect(Collectors.toSet());
	}

	public Set<Skill> getSkills() {
		N1qlQueryResult result = referenceBucket
				.query(select(FIELD_NAME).from(i(referenceBucket.name())).where(x("type").eq(s(TYPE_SKILL))));
		System.out.println("total results for getSkills = " + result.allRows().size());
		return result.allRows().stream()
				.map(extractToSkill)
				.collect(Collectors.toSet());
	}

	public void addSkill(Skill skill) {
		JsonObject skillData = JsonObject.create()
				.put("type", TYPE_SKILL)
				.put(FIELD_NAME, skill.getName());
		JsonDocument doc = JsonDocument.create(skill.getId().toString(), skillData);
		referenceBucket.insert(doc);
	}

	public void addSkillGroup(SkillGroup skillGroup) {
		JsonObject skillGroupData = JsonObject.create()
				.put("type", TYPE_SKILLGROUP)
				.put(FIELD_NAME, skillGroup.getName());
		JsonDocument doc = JsonDocument.create(skillGroup.getId().toString(), skillGroupData);
		referenceBucket.insert(doc);
	}

	Function<N1qlQueryRow, Skill> extractToSkill = row -> new Skill(row.value().getString(FIELD_NAME));

	Function<N1qlQueryRow, SkillGroup> extractToSkillGroup = row -> new SkillGroup(row.value().getString(FIELD_NAME));

}
