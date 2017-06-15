package com.rpgcampaigner.woin.core.entity;

/**
 * @author jmccormick
 * @since 3/14/17
 */
public class Skill {

	public Skill(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Skill) {
			return this.name.equalsIgnoreCase(((Skill)obj).getName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
