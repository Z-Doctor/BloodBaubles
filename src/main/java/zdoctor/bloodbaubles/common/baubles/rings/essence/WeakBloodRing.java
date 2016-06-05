package zdoctor.bloodbaubles.common.baubles.rings.essence;

import java.util.List;

import WayofTime.bloodmagic.registry.ModItems;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import zdoctor.bloodbaubles.common.ModMain;
import zdoctor.bloodbaubles.common.ZRenderRegistery;
import zdoctor.bloodbaubles.common.ZRing;

public class WeakBloodRing extends EssenceRing {
	private static final Object[] recipeIron = new Object[] { "b", "r", 'b', ModItems.orbWeak, 'r',
			ZRing.BasicIronRing };
	private static final Object[] recipeGold = new Object[] { "b", "r", 'b', ModItems.orbWeak, 'r',
			ZRing.BasicGoldRing };
	
	public WeakBloodRing() {
		super("WeakIronBloodRing", null, true);
//		GameRegistry.addRecipe(new ItemStack(this, 1, 0), recipeIron);
//		GameRegistry.addRecipe(new ItemStack(this, 1, 1), recipeGold);
		ModelBakery.registerItemVariants(this, this.file,
				new ResourceLocation(ModMain.MODID + ":rings/WeakGoldBloodRing"));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + ModMain.MODID + "_Weak" + (stack.getMetadata() == 0 ? "Iron" : "Gold") + "BloodRing";
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		subItems.add(new ItemStack(itemIn, 1, 0));
		subItems.add(new ItemStack(itemIn, 1, 1));
	}
	
	@Override
	public void registerRender(String nameIn) {
		super.registerRender(nameIn);
		ZRenderRegistery.registerItem("rings/WeakGoldBloodRing", this, 1);
	}
	
	
	@Override
	public int getMaxCapacity(ItemStack itemStackIn) {
		return (int) (ModItems.orbWeak.getCapacity() * (itemStackIn.getMetadata() == 0 ? 1 : 1.33));
	}
}
