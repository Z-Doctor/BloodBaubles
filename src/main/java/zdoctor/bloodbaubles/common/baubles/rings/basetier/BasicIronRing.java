package zdoctor.bloodbaubles.common.baubles.rings.basetier;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BasicIronRing extends BloodRing {
	public BasicIronRing() {
		super("BasicIronRing");
	}

	@Override
	public void registerRecipe() {
		Object[] recipe = { " i ", "i i", " i ", 'i', Items.IRON_INGOT };
		GameRegistry.addShapedRecipe(new ItemStack(this), recipe);
	}

	@Override
	public void registerVariants() {

	}

}
