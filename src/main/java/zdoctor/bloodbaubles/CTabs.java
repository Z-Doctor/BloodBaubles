package zdoctor.bloodbaubles;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import zdoctor.bloodbaubles.init.Rings;

public final class CTabs {
	public static void registerTabs() {};
	
	public static CreativeTabs BloodRings = new CreativeTabs("BloodBaubles") {
		
		@Override
		public Item getTabIconItem() {
			return Rings.GodsGift;
		}
	};
}
