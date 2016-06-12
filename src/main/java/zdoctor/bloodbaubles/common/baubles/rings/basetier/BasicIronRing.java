package zdoctor.bloodbaubles.common.baubles.rings.basetier;

import net.minecraft.init.Items;

public class BasicIronRing extends BloodRing {
	public BasicIronRing() {
		super("BasicIronRing");
	}

	public void registerRecipe() {
		Object[] recipe = { " i ", "i i", " i ", 'i', Items.IRON_INGOT };
		net.minecraftforge.fml.common.registry.GameRegistry.addShapedRecipe(new net.minecraft.item.ItemStack(this),
				recipe);
	}

	public void registerVariants() {
	}
}
