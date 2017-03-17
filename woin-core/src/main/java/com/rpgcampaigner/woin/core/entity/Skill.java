package com.rpgcampaigner.woin.core.entity;

import java.util.UUID;

/**
 * @author jmccormick
 * @since 3/14/17
 */
public class Skill {

	public Skill(String name) {
		this.id = "skill::" + name;
		this.name = name;
	}

	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
