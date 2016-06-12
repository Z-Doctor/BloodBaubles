package zdoctor.bloodbaubles.common.baubles.rings.mastertier;

import java.util.List;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zdoctor.bloodbaubles.ModMain;
import zdoctor.bloodbaubles.common.ZRenderRegistery;
import zdoctor.bloodbaubles.common.ZRing;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.BloodRing;

public class GodsGift extends BloodRing {
	// Todo: Add config option for recipe
	public GodsGift() {
		super("GodsGift", true);
	}

	@Override
	public void registerRender(String nameIn) {
		ZRenderRegistery.registerItem("rings/GodsGift_Inactive", this, 0);
		ZRenderRegistery.registerItem("rings/GodsGift_Active", this, 1);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + ModMain.MODID + "_GodsGift_" + (stack.getMetadata() == 0 ? "Inactive" : "Active");
	}

	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		subItems.add(new ItemStack(itemIn, 1, 0));
		subItems.add(new ItemStack(itemIn, 1, 1));
	}

	@Override
	public void registerRecipe() {
		Object[] recipe = { "n", "g", 'n', Items.NETHER_STAR, 'g', ZRing.BasicGoldRing };
		GameRegistry.addShapedRecipe(new ItemStack(this, 1, 0), recipe);
	}

	@Override
	public void registerVariants() {
		ModelBakery.registerItemVariants(this, new ResourceLocation(ModMain.MODID + ":rings/GodsGift_Inactive"),
				new ResourceLocation(ModMain.MODID + ":rings/GodsGift_Active"));
	}
}