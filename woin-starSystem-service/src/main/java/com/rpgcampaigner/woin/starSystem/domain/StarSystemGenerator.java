package com.rpgcampaigner.woin.starSystem.domain;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

import com.rpgcampaigner.woin.core.universe.SpectralType;
import com.rpgcampaigner.woin.core.universe.Star;
import com.rpgcampaigner.woin.core.universe.StarSize;

/**
 * @author jmccormick
 * @since 5/16/17
 */
public class StarSystemGenerator {


	Supplier<Star> randomStar = () -> {
		Star randomStar = new Star();

		int d66Roll = ThreadLocalRandom.current().nextInt(1, 7) * 10 + ThreadLocalRandom.current().nextInt(1, 7);
		switch (d66Roll) {
			case 11:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.A);
				break;
			case 12:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.B);
				break;
			case 13:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.F);
				break;
			case 14:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.D);
				break;
			case 15:
			case 16:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.F);
				break;
			case 21:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.K);
				break;
			case 22:
			case 23:
			case 24:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.G);
				break;
			case 25:
				randomStar.setSize(StarSize.MAIN_SEQUENCE); //?
				randomStar.setSpectralType(SpectralType.C);
				break;
			case 26:
				randomStar.setSize(StarSize.GIANT);
				randomStar.setSpectralType(SpectralType.M);
				break;
			case 31:
			case 32:
			case 33:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.K);
				break;
			case 34:
				randomStar.setSize(StarSize.GIANT);
				randomStar.setSpectralType(SpectralType.S);
				break;
			case 35:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.M);
				break;
			case 36:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.L);
				break;
			case 41:
				randomStar.setSize(StarSize.MAIN_SEQUENCE);
				randomStar.setSpectralType(SpectralType.F);
				break;
			case 42:
			case 43:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Y);
				break;
			case 44:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.T);
				break;
			case 45:
			case 46:
				randomStar.setSize(StarSize.GIANT);
				randomStar.setSpectralType(SpectralType.O);
				break;
			case 51:
			case 52:
				randomStar.setSize(StarSize.SUPER_GIANT);
				randomStar.setSpectralType(SpectralType.L);
				break;
			case 53:
			case 54:
				randomStar.setSize(StarSize.SUB_GIANT);
				randomStar.setSpectralType(SpectralType.O);
				break;
			case 55:
			case 56:
				randomStar.setSize(StarSize.SUPER_GIANT);
				randomStar.setSpectralType(SpectralType.W);
				break;
			case 61:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Xi);
				break;
			case 62:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Xii);
				break;
			case 63:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Xiii);
				break;
			case 64:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Xiv);
				break;
			case 65:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Xv);
				break;
			case 66:
				randomStar.setSize(StarSize.DWARF);
				randomStar.setSpectralType(SpectralType.Xvi);
				break;
			default:
				throw new IllegalArgumentException("Invalid d66 value: " + d66Roll);
		}
		// TODO Name Generation
		return randomStar;
	};

}
