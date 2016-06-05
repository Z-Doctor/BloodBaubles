package zdoctor.bloodbaubles.common.baubles.rings.mastertier;

import java.util.List;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zdoctor.bloodbaubles.common.ModMain;
import zdoctor.bloodbaubles.common.ZRenderRegistery;
import zdoctor.bloodbaubles.common.ZRing;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.BloodRing;

public class GodsGift extends BloodRing {
	public static Object[] recipe = { "n", "g", 'n', Items.NETHER_STAR, 'g', ZRing.BasicGoldRing };

	// Todo: Add config option for recipe
	public GodsGift() {
		super("GodsGift", null, true);
		GameRegistry.addShapedRecipe(new ItemStack(this, 1, 1), recipe);
		ModelBakery.registerItemVariants(this, this.file,
				new ResourceLocation(ModMain.MODID + ":rings/GodsGift_Active"));
	}
	
	@Override
	public void registerRender(String nameIn) {
		super.registerRender(nameIn);
		ZRenderRegistery.registerItem("rings/" + nameIn + "_Active", this, 1);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "_" + (stack.getMetadata() == 0 ? "Inactive" : "Active");
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		subItems.add(new ItemStack(itemIn, 1, 0));
		subItems.add(new ItemStack(itemIn, 1, 1));
	}
}
