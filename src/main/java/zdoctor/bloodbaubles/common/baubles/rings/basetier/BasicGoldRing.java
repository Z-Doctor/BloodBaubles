package zdoctor.bloodbaubles.common.baubles.rings.basetier;

import net.minecraft.init.Items;

public class BasicGoldRing extends BloodRing {
	public static Object[] recipe = { " g ", "g g", " g ", 'g', Items.GOLD_INGOT};

	public BasicGoldRing() {
		super("BasicGoldRing", recipe);
	}
}
