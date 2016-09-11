package zdoctor.bloodbaubles.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class ModCreativeTabs {
	public static void initTabs() {
	};

	public static CreativeTabs BloodRings = new CreativeTabs("BloodBaubles") {

		@Override
		public Item getTabIconItem() {
			return Rings.GodsGift;
		}
	};
}
