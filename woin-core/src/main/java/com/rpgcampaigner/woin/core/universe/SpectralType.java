package com.rpgcampaigner.woin.core.universe;

/**
 * @author jmccormick
 * @since 5/15/17
 */
public enum SpectralType {
	O ("ultraviolet"),
	B ("blue-white"),
	A ("white"),
	F ("light yellow"),
	G ("yellow"),
	K ("orange"),
	M ("red"),
	W ("wolf-rayet"),
	L ("red dwarf"),
	T ("methane dwarf"),
	Y ("brown dwarf"),
	C ("carbon star"),
	S ("cool giant"),
	D ("white dwarf, degenerate"),
	Xi ("neutron star"),
	Xii ("quark star"),
	Xiii ("black hole"),
	Xiv ("dark star"),
	Xv ("boson star"),
	Xvi ("ice star");

	private String description;

	SpectralType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
