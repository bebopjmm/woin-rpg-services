package com.rpgcampaigner.woin.core.universe;

/**
 * @author jmccormick
 * @since 5/18/17
 */
public class Atmosphere {
	private AtmosphereDensity density;
	private AtmosphereComposition primaryComposition;
	private AtmosphereComposition traceComposition;

	public AtmosphereDensity getDensity() {
		return density;
	}

	public void setDensity(AtmosphereDensity density) {
		this.density = density;
	}

	public AtmosphereComposition getPrimaryComposition() {
		return primaryComposition;
	}

	public void setPrimaryComposition(AtmosphereComposition primaryComposition) {
		this.primaryComposition = primaryComposition;
	}

	public AtmosphereComposition getTraceComposition() {
		return traceComposition;
	}

	public void setTraceComposition(AtmosphereComposition traceComposition) {
		this.traceComposition = traceComposition;
	}
}
