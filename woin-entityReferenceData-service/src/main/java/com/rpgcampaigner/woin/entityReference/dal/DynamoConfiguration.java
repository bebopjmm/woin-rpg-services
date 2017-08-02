package com.rpgcampaigner.woin.entityReference.dal;

/**
 * @author jmccormick
 * @since 6/14/17
 */
public class DynamoConfiguration {

	private String skillGroupTableName;

	private String region;

	public String getSkillGroupTableName() {
		return skillGroupTableName;
	}

	public void setSkillGroupTableName(String skillGroupTableName) {
		this.skillGroupTableName = skillGroupTableName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
