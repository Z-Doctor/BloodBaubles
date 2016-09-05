package zdoctor.bloodbaubles.enums;

public enum EnumRingMaterial {
	Wood(0.1d), Stone(0.25d), Iron(0.85d), Gold(1.15d), Diamond(2d);

	private double multiplier;

	EnumRingMaterial(double multiIn) {
		this.multiplier = multiIn;
	}

	public double getMultiplier() {
		return this.multiplier;
	}
	
	
}
