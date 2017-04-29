package zdoctor.bloodbaubles.common.baubles;

public abstract class BloodRing extends BloodBauble {

	public BloodRing(String nameIn) {
		this(nameIn, false);
	}

	public BloodRing(String nameIn, boolean hasSubTypes) {
		super(nameIn, hasSubTypes);
	}
}