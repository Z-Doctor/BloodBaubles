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

	private static class PriestBlessing implements ITradeList {
		public PriestBlessing() {
			IForgeRegistry<VillagerProfession> professionList = VillagerRegistry.instance().getRegistry();
			VillagerCareer bishop = new VillagerCareer(
					VillagerRegistry.instance().getRegistry().getValue(new ResourceLocation("minecraft:priest")),
					"bishop");
			bishop.addTrade(1, this);
			// professionList.register(bishop);
			// List<VillagerProfession> professionList =
			// VillagerRegistry.instance().getRegistry().getValues();
			// for (VillagerProfession prof : professionList) {
			// if (prof.getRegistryName().toString().equals("minecraft:priest"))
			// {
			// // VillagerCareer babtist = new VillagerCareer(prof,
			// // "baptist");
			// VillagerCareer priest = prof.getCareer(1);
			// priest.addTrade(1, this);
			// // babtist.addTrade(1, this);
			// }
			// }
		}

		@Override
		public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {
			recipeList.add(new MerchantRecipe(new ItemStack(ZBaubles.GodsGift, 1, 0),
					new ItemStack(Items.EMERALD, 64, 0), new ItemStack(ZBaubles.GodsGift, 1, 1)));
		}
	}
}