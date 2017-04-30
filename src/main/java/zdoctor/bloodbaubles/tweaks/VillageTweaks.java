package zdoctor.bloodbaubles.tweaks;

import java.util.Random;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.fml.common.registry.IForgeRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import zdoctor.bloodbaubles.common.ZBaubles;

public class VillageTweaks {
	public static void postInit() {
		new PriestBlessing();
	}

	public static class PriestBlessing {
		public PriestBlessing() {
			IForgeRegistry<VillagerProfession> professionList = VillagerRegistry.instance().getRegistry();
			VillagerCareer bishop = new VillagerCareer(
					VillagerRegistry.instance().getRegistry().getValue(new ResourceLocation("minecraft:priest")),
					"bishop");
			bishop.addTrade(1, new PriestBlessing.BasicTrades());
		}

		public static class BasicTrades implements ITradeList {
			@Override
			public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {
				recipeList.add(new MerchantRecipe(new ItemStack(ZBaubles.GodsGift, 1, 0),
						new ItemStack(Items.EMERALD, 64, 0), new ItemStack(ZBaubles.GodsGift, 1, 1)));
				recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 4, 0),
						new ItemStack(ZBaubles.BasicRing, 1, 0)));
				recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 7, 0),
						new ItemStack(ZBaubles.BasicRing, 1, 1)));
			}
		}
	}
}