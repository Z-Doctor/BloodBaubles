package zdoctor.bloodbaubles;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.common.ZBaubles;

public class CTabs {
	public static CreativeTabs BloodRings = new CreativeTabs("BloodBaubles") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ZBaubles.BasicRing);
		}
	};

	public static void preInit() {
	}
}
