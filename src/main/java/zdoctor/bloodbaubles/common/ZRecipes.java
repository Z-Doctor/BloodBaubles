package zdoctor.bloodbaubles.common;

import WayofTime.bloodmagic.registry.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import zdoctor.bloodbaubles.common.baubles.EssenceRing;
import zdoctor.lazymodder.easy.EasyFunctions;

public class ZRecipes {

	public static void init() {
		reg(new ItemStack(ZBaubles.BasicRing, 1, 0), " i ", "i i", " i ", 'i', Items.IRON_INGOT);
		reg(new ItemStack(ZBaubles.BasicRing, 1, 1), " i ", "i i", " i ", 'i', Items.GOLD_INGOT);

		for (int i = 0; i < ZBaubles.EssenceRing.getSubCount(); i++) {
			int material = (int) (i / (EssenceRing.orbList.length));
			int itemMeta = i % EssenceRing.orbList.length;
			reg(new ItemStack(ZBaubles.EssenceRing, 1, i), "o", "r", 'o', new ItemStack(ModItems.BLOOD_ORB, 1, itemMeta), 'r',
					new ItemStack(ZBaubles.BasicRing, 1, material));
		}

		reg(new ItemStack(ZBaubles.GodsGift, 1, 0), "s", "r", 's', Items.NETHER_STAR, 'r',
				new ItemStack(ZBaubles.BasicRing, 1, 1));

		reg(new ItemStack(ZBaubles.InsightfulTrinket, 1, 0), " s ", "sos", " p ", 's', Items.STRING, 'o',
				new ItemStack(ModItems.BLOOD_ORB, 1, OreDictionary.WILDCARD_VALUE), 'p', ModItems.SIGIL_DIVINATION);
		reg(new ItemStack(ZBaubles.InsightfulTrinket, 1, 1), " s ", "sos", " p ", 's', Items.STRING, 'o',
				new ItemStack(ModItems.BLOOD_ORB, 1, OreDictionary.WILDCARD_VALUE), 'p', ModItems.SIGIL_SEER);
	}

	public static void reg(ItemStack itemStack, Object... components) {
		EasyFunctions.addRecipe(itemStack, components);
	}
}
