package zdoctor.bloodbaubles.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.common.ZBaubles;

public class BloodBaubles {
	public static CreativeTabs BloodRings = new CreativeTabs("BloodBaubles") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ZBaubles.BasicRing);
		}
	};

	public static void preInit() {
	}
}
