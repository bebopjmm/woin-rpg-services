package com.rpgcampaigner.woin.characterReference.dal;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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

import io.advantageous.boon.core.Str;
import io.advantageous.boon.core.Sys;

import static com.couchbase.client.java.query.Select.select;
import static com.couchbase.client.java.query.dsl.Expression.i;
import static com.couchbase.client.java.query.dsl.Expression.s;
import static com.couchbase.client.java.query.dsl.Expression.x;

/**
 * @author jmccormick
 * @since 3/17/17
 */
public class ReferenceRepository {

	// TODO Caching of Skills and SkillGroups

	private static final String TYPE_SKILLGROUP = "skillGroup";
	private static final String TYPE_SKILL = "skill";
	private static final String FIELD_NAME = "name";

	private Bucket referenceBucket;

	public ReferenceRepository(Bucket referenceBucket) {
		this.referenceBucket = referenceBucket;
	}

	public Set<SkillGroup> getAllSkillGroups() {
		N1qlQueryResult result = referenceBucket
				.query(select("*").from(i(referenceBucket.name())).where(x("type").eq(s(TYPE_SKILLGROUP))));
		System.out.println("total results for getAllSkillGroups = " + result.allRows().size());
		return result.allRows().stream()
				.map(extractToSkillGroup)
				.collect(Collectors.toSet());
	}

	public SkillGroup getSkillGroup(final String name) {
		Objects.requireNonNull(name);

		JsonDocument doc = referenceBucket.get(TYPE_SKILLGROUP + "::" + name);
		return doc == null ?
				null :
				new SkillGroup(doc.content().getString("name"));
	}

	public Set<Skill> getAllSkills() {
		N1qlQueryResult result = referenceBucket
				.query(select(FIELD_NAME).from(i(referenceBucket.name())).where(x("type").eq(s(TYPE_SKILL))));
		System.out.println("total results for getAllSkills = " + result.allRows().size());
		return result.allRows().stream()
				.map(extractToSkill)
				.collect(Collectors.toSet());
	}

	public Skill getSkill(final String skillName) {
		Objects.requireNonNull(skillName);

		JsonDocument doc = referenceBucket.get(TYPE_SKILL + "::" + skillName);
		return doc == null ?
				null :
				new Skill(doc.content().getString("name"));
	}

	public void createSkill(Skill skill) {
		Objects.requireNonNull(skill);

		JsonObject skillData = JsonObject.create()
				.put("type", TYPE_SKILL)
				.put(FIELD_NAME, skill.getName());
		JsonDocument doc = JsonDocument.create(TYPE_SKILL + "::" + skill.getName(), skillData);
		referenceBucket.insert(doc);
	}

	public void createSkillGroup(SkillGroup skillGroup) {
		Objects.requireNonNull(skillGroup);

		JsonDocument doc = JsonDocument.create(
				TYPE_SKILLGROUP + "::" + skillGroup.getName(),
				convertSkillGroup.apply(skillGroup));
		referenceBucket.insert(doc);
	}

	public void updateSkillGroup(SkillGroup skillGroup) {
		Objects.requireNonNull(skillGroup);

		JsonDocument doc = JsonDocument.create(
				TYPE_SKILLGROUP + "::" + skillGroup.getName(),
				convertSkillGroup.apply(skillGroup));
		referenceBucket.replace(doc);
	}

	Function<N1qlQueryRow, Skill> extractToSkill = row -> new Skill(row.value().getString(FIELD_NAME));

	Function<N1qlQueryRow, SkillGroup> extractToSkillGroup = row -> {
		JsonObject groupObject = (JsonObject)row.value().get(referenceBucket.name());

		SkillGroup group = new SkillGroup(groupObject.getString(FIELD_NAME));
		Optional.ofNullable(groupObject.getArray("skillSet"))
				.ifPresent(skillSet ->
							skillSet.forEach(skillName -> group.getSkillSet().add(getSkill((String) skillName))));
		return group;
	};

	Function<SkillGroup, JsonObject> convertSkillGroup = group -> {
		List<String> skillNames = group.getSkillSet().stream().map(skill -> skill.getName()).collect(Collectors.toList());
		return JsonObject.create()
				.put("type", TYPE_SKILLGROUP)
				.put(FIELD_NAME, group.getName())
				.put("skillSet", skillNames);
	};

}
