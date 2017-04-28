package zdoctor.bloodbaubles.common;

import net.minecraft.item.Item;
import zdoctor.bloodbaubles.common.baubles.SeersPendant;

public class ZPendant {
	public static Item SeersPendant;

	public static void preInit() {
		SeersPendant = new SeersPendant();
	}
}
