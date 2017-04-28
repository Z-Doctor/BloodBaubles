package zdoctor.bloodbaubles.common.baubles;

import net.minecraft.init.Items;

public class BasicRing extends BloodRing {
	public BasicRing() {
		super("BasicRing", true);
		setSubCount(2);
	}
	
	@Override
	public String getNameFromDamage(int itemDamage) {
		return super.getRegistryName() + ((itemDamage == 0) ? "_iron" : "_gold");
	}

//	public void registerRecipe() {
//		Object[] recipe = { " i ", "i i", " i ", 'i', Items.IRON_INGOT };
//		net.minecraftforge.fml.common.registry.GameRegistry.addShapedRecipe(new net.minecraft.item.ItemStack(this),
//				recipe);
//	}
}
