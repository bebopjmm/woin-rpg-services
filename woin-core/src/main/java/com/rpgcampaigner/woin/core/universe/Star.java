package com.rpgcampaigner.woin.core.universe;

/**
 * @author jmccormick
 * @since 5/16/17
 */
public class Star {
	private String name;

	private SpectralType spectralType;

	private StarSize size;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SpectralType getSpectralType() {
		return spectralType;
	}

	public void setSpectralType(SpectralType spectralType) {
		this.spectralType = spectralType;
	}

	public StarSize getSize() {
		return size;
	}

	public void setSize(StarSize size) {
		this.size = size;
	}
}
