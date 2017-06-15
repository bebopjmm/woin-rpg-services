package com.rpgcampaigner.woin.entityReference.dal;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.rpgcampaigner.woin.core.entity.Skill;
import com.rpgcampaigner.woin.core.entity.SkillGroup;

/**
 * @author jmccormick
 * @since 6/14/17
 */
public class ReferenceDynamoRepository implements ReferenceRepository {
	private final AmazonDynamoDB client;
	private final DynamoDB dynamoDB;

	private final DynamoConfiguration configuration;

	public ReferenceDynamoRepository(DynamoConfiguration configuration) {
		this.configuration = configuration;
		this.client = AmazonDynamoDBClientBuilder.standard()
				.withRegion(Regions.valueOf(configuration.getRegion()))
				.build();
		this.dynamoDB = new DynamoDB(client);
	}

	@Override
	public Set<SkillGroup> getAllSkillGroups() {
		ScanRequest scanRequest = new ScanRequest().withTableName(configuration.getSkillGroupTableName());
		ScanResult scanResult = client.scan(scanRequest);
		return scanResult.getItems().stream()
				.map(mapToSkillGroup)
				.collect(Collectors.toSet());
	}

	@Override
	public Optional<SkillGroup> getSkillGroup(String name) {
		Objects.requireNonNull(name);
		Table table = dynamoDB.getTable(configuration.getSkillGroupTableName());
		Optional<Item> item = Optional.ofNullable(table.getItem("Name", name));

		return item.isPresent() ?
				Optional.of (convertToSkillGroup.apply(item.get())) :
				Optional.empty();
	}

	@Override
	public void createSkillGroup(SkillGroup skillGroup) {

	}

	@Override
	public void updateSkillGroup(SkillGroup skillGroup) {

	}

	private final Function<Item, SkillGroup> convertToSkillGroup = item -> {
		SkillGroup skillGroup = new SkillGroup(item.getString("Name"));
		item.getStringSet("skills").stream()
				.forEach(skillName -> skillGroup.getSkillSet().add(new Skill(skillName)));
		return skillGroup;
	};

	private final Function<Map<String, AttributeValue>, SkillGroup> mapToSkillGroup = map -> {
		SkillGroup skillGroup = new SkillGroup(map.get("Name").getS());
		map.get("skills").getSS().stream()
				.forEach(skillName -> skillGroup.getSkillSet().add(new Skill(skillName)));
		return skillGroup;
	};
}
