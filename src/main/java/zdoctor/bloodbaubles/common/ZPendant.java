package zdoctor.bloodbaubles.common;

import net.minecraft.item.Item;
import zdoctor.bloodbaubles.common.baubles.pendants.SeersPendant;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.BasicGoldRing;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.BasicIronRing;
import zdoctor.bloodbaubles.common.baubles.rings.essence.WeakBloodRing;
import zdoctor.bloodbaubles.common.baubles.rings.mastertier.GodsGift;

public class ZPendant {
	public static Item SeersPendant;
	public static void init() {
		SeersPendant = new SeersPendant();
	}
}