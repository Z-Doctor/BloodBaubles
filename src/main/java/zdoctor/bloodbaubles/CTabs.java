package zdoctor.bloodbaubles;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import zdoctor.bloodbaubles.common.ZRing;

public class CTabs {
	public static CreativeTabs BloodRings = new CreativeTabs("BloodBaubles") {
		@Override
		public Item getTabIconItem() {
			return ZRing.BasicGoldRing;
		}
	};

	public static void preInit() {
	}
}
