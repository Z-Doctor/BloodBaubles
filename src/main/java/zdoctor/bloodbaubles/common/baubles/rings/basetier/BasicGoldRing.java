package zdoctor.bloodbaubles.common.baubles.rings.basetier;

import net.minecraft.init.Items;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BasicGoldRing extends BloodRing {
	public BasicGoldRing() {
		super("BasicGoldRing");
	}

	public void registerRecipe() {
		Object[] recipe = { " g ", "g g", " g ", 'g', Items.GOLD_INGOT };
		GameRegistry.addShapedRecipe(new net.minecraft.item.ItemStack(this), recipe);
	}

	public void registerVariants() {
	}
}
