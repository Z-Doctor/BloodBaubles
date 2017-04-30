package zdoctor.bloodbaubles.common.baubles;

import zdoctor.bloodbaubles.common.item.BloodBauble;

public abstract class BloodRing extends BloodBauble {

	public BloodRing(String nameIn) {
		this(nameIn, false);
	}

	public BloodRing(String nameIn, boolean hasSubTypes) {
		super(nameIn, hasSubTypes);
	}
}