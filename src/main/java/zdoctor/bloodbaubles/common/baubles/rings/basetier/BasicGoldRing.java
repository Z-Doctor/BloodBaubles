package zdoctor.bloodbaubles.common.baubles.rings.basetier;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BasicGoldRing extends BloodRing {
	public BasicGoldRing() {
		super("BasicGoldRing");
	}

	@Override
	public void registerRecipe() {
		Object[] recipe = { " g ", "g g", " g ", 'g', Items.GOLD_INGOT };
		GameRegistry.addShapedRecipe(new ItemStack(this), recipe);
	}

	@Override
	public void registerVariants() {

	}
}
