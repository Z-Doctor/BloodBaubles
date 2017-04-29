package zdoctor.bloodbaubles.common.baubles;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BasicRing extends BloodRing {
	public BasicRing() {
		super("BasicRing", true);
		setSubCount(2);
	}
	
	@Override
	public String getNameFromDamage(int itemDamage) {
		return super.getRegistryName().getResourcePath() + ((itemDamage == 0) ? "_iron" : "_gold");
	}


//	public void registerRecipe() {
//		Object[] recipe = { " i ", "i i", " i ", 'i', Items.IRON_INGOT };
//		net.minecraftforge.fml.common.registry.GameRegistry.addShapedRecipe(new net.minecraft.item.ItemStack(this),
//				recipe);
//	}
}
