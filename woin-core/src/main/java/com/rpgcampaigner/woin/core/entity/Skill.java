package com.rpgcampaigner.woin.core.entity;

import java.util.UUID;

/**
 * @author jmccormick
 * @since 3/14/17
 */
public class Skill {

	private UUID id;

	private String name;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
