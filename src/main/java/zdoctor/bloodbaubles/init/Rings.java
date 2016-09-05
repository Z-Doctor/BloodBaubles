package zdoctor.bloodbaubles.init;

import net.minecraft.item.Item;
import zdoctor.bloodbaubles.References;
import zdoctor.bloodbaubles.baubles.rings.BasicRing;
import zdoctor.bloodbaubles.baubles.rings.GodsGift;
import zdoctor.bloodbaubles.baubles.rings.test.TestRing;
import zdoctor.bloodbaubles.baubles.rings.test.TestVariantRing;

/**
 * Rings should be registered here, everything else should be taken care of in
 * the class (where needed).
 * 
 * @author Z_Doctor
 */
public class Rings {
	public static Item BasicRing = new BasicRing();
	public static Item GodsGift = new GodsGift();

	public static void init() {
		if (References.debug) {
			new TestRing();
			// new TestMultiRing();
			new TestVariantRing();
		}
	}
}
