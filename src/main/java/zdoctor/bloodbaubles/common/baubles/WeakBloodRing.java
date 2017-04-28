package zdoctor.bloodbaubles.common.baubles;

import java.util.List;

import WayofTime.bloodmagic.api.registry.OrbRegistry;
import WayofTime.bloodmagic.registry.ModItems;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zdoctor.bloodbaubles.ModMain;
import zdoctor.bloodbaubles.common.ZRenderRegistery;
import zdoctor.bloodbaubles.common.ZRing;

public class WeakBloodRing extends EssenceRing {
	public WeakBloodRing() {
		super("WeakBloodRing", true);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + ModMain.MODID + "_Weak" + (stack.getMetadata() == 0 ? "Iron" : "Gold") + "BloodRing";
	}

//	@Override
//	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
//		subItems.add(new ItemStack(itemIn, 1, 0));
//		subItems.add(new ItemStack(itemIn, 1, 1));
//	}

//	@Override
//	public void registerRender(String nameIn) {
//		ZRenderRegistery.registerItem("rings/WeakIronBloodRing", this, 0);
//		ZRenderRegistery.registerItem("rings/WeakGoldBloodRing", this, 1);
//	}

	@Override
	public int getMaxCapacity(ItemStack itemStackIn) {
		return (int) (ModItems.ORB_WEAK.getCapacity() * (itemStackIn.getMetadata() == 0 ? 1 : 1.33));
	}

//	@Override
//	public void registerRecipe() {
//		Object[] recipeIron = new Object[] { "b", "r", 'b', OrbRegistry.getOrbStack(ModItems.orbWeak), 'r',
//				ZRing.BasicIronRing };
//		Object[] recipeGold = new Object[] { "b", "r", 'b', OrbRegistry.getOrbStack(ModItems.orbWeak), 'r',
//				ZRing.BasicGoldRing };
//		GameRegistry.addShapedRecipe(new ItemStack(this, 1, 0), recipeIron);
//		GameRegistry.addShapedRecipe(new ItemStack(this, 1, 1), recipeGold);
//	}

//	@Override
//	public void registerVariants() {
//		ModelBakery.registerItemVariants(this, new ResourceLocation(ModMain.MODID + ":rings/WeakIronBloodRing"),
//				new ResourceLocation(ModMain.MODID + ":rings/WeakGoldBloodRing"));
//
//	}
}