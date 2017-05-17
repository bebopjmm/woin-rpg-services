package com.rpgcampaigner.woin.core.universe;

/**
 * @author jmccormick
 * @since 5/16/17
 */
public enum PlanetarySize {
	o ("orbital"),
	s ("small"),
	m ("medium"),
	l ("large"),
	g ("giant"),
	d ("dwarf");

	String description;

	PlanetarySize(String description) {
		this.description = description;
	}
}
