package zdoctor.bloodbaubles.baubles.rings.test;

import zdoctor.bloodbaubles.References;
import zdoctor.bloodbaubles.baubles.VariantBloodRing;

public class TestVariantRing extends VariantBloodRing {

	public TestVariantRing() {
		super(References.TEST_VARIANT);
		this.addVariant("On");
		this.addVariant("Off");
		this.addVariant("Asleep");
		this.addVariant("Netral");
	}

}
