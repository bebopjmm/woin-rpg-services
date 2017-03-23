package com.rpgcampaigner.woin.core.entity;


import com.rpgcampaigner.woin.core.DynamicValue;

/**
 * @author jmccormick
 * @since 2/21/17
 */
public class AttributeValue extends DynamicValue {

	private AttributeEnum attribute;

	private int poolSize;

	public AttributeValue(int score, AttributeEnum attribute) {
		super(score);
		this.setName(attribute.name());
		this.attribute = attribute;
		computePoolSize();
	}

	public AttributeEnum getAttribute() {
		return attribute;
	}

	public int getPoolSize() {
		return poolSize;
	}

	@Override
	public void onModifierChange(int delta) {
		super.onModifierChange(delta);
		computePoolSize();
	}

	private void computePoolSize() {
		switch (this.getCurrentValue()) {
			case 1:
			case 2:
				this.poolSize = 1;
				break;
			case 3:
			case 4:
			case 5:
				this.poolSize = 2;
				break;
			case 6:
			case 7:
			case 8:
			case 9:
				this.poolSize = 3;
				break;
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
				this.poolSize = 4;
				break;
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
				this.poolSize = 5;
				break;
			case 21:
			case 22:
			case 23:
			case 24:
			case 25:
			case 26:
			case 27:
				this.poolSize = 6;
				break;
			case 28:
			case 29:
			case 30:
			case 31:
			case 32:
			case 33:
			case 34:
			case 35:
				this.poolSize = 7;
				break;
		}
	}
}
