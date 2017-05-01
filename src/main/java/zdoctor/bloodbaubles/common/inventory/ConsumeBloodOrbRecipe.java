package zdoctor.bloodbaubles.common.inventory;

import java.util.Map;

import com.google.common.collect.Maps;

import WayofTime.bloodmagic.api.orb.IBloodOrb;
import WayofTime.bloodmagic.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import zdoctor.lazymodder.inventory.NoContainerRecipes;

public class ConsumeBloodOrbRecipe extends NoContainerRecipes {
	private OrbConsumption orbLevel;

	public ConsumeBloodOrbRecipe(int width, int height, ItemStack[] ingredientsIn, ItemStack output) {
		super(width, height, ingredientsIn, output);
	}

	public ConsumeBloodOrbRecipe setOrbLevel(OrbConsumption orbLevel) {
		this.orbLevel = orbLevel;
		return this;
	}

	public static ConsumeBloodOrbRecipe addRecipe(ItemStack stack, Object... recipeComponents) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;

		if (recipeComponents[i] instanceof String[]) {
			String[] astring = (String[]) ((String[]) recipeComponents[i++]);

			for (String s2 : astring) {
				++k;
				j = s2.length();
				s = s + s2;
			}
		} else {
			while (recipeComponents[i] instanceof String) {
				String s1 = (String) recipeComponents[i++];
				++k;
				j = s1.length();
				s = s + s1;
			}
		}

		Map<Character, ItemStack> map;

		for (map = Maps.<Character, ItemStack>newHashMap(); i < recipeComponents.length; i += 2) {
			Character character = (Character) recipeComponents[i];
			ItemStack itemstack = ItemStack.EMPTY;

			if (recipeComponents[i + 1] instanceof Item) {
				itemstack = new ItemStack((Item) recipeComponents[i + 1]);
			} else if (recipeComponents[i + 1] instanceof Block) {
				itemstack = new ItemStack((Block) recipeComponents[i + 1], 1, 32767);
			} else if (recipeComponents[i + 1] instanceof ItemStack) {
				itemstack = (ItemStack) recipeComponents[i + 1];
			}

			map.put(character, itemstack);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];

		for (int l = 0; l < j * k; ++l) {
			char c0 = s.charAt(l);

			if (map.containsKey(Character.valueOf(c0))) {
				aitemstack[l] = ((ItemStack) map.get(Character.valueOf(c0))).copy();
			} else {
				aitemstack[l] = ItemStack.EMPTY;
			}
		}

		ConsumeBloodOrbRecipe noContainerRecipes = new ConsumeBloodOrbRecipe(j, k, aitemstack, stack);
		GameRegistry.addRecipe(noContainerRecipes);
		return noContainerRecipes;
	}

	@Override
	public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
		NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(inv.getSizeInventory(), ItemStack.EMPTY);

		for (int i = 0; i < nonnulllist.size(); ++i) {
			ItemStack itemStack = inv.getStackInSlot(i);
			if (itemStack.getItem() instanceof IBloodOrb)
				if (this.orbLevel == OrbConsumption.ALL || OrbConsumption.isLevelConsumed(itemStack, orbLevel))
					nonnulllist.set(i, ItemStack.EMPTY);
				else
					nonnulllist.set(i, itemStack.getItem().getContainerItem(itemStack));
			else
				nonnulllist.set(i, itemStack.getItem().getContainerItem(itemStack));
		}

		return nonnulllist;
	}

	public static enum OrbConsumption {
		WEAK(ModItems.ORB_WEAK.getTier()), APPRENTICES(ModItems.ORB_APPRENTICE.getTier()), MAGICIANS(
				ModItems.ORB_MAGICIAN.getTier()), MASTERS(ModItems.ORB_MASTER.getTier()), ARCHMAGES(
						ModItems.ORB_ARCHMAGE.getTier()), TRANSCENDENTS(
								ModItems.ORB_TRANSCENDENT.getTier()), ALL(OreDictionary.WILDCARD_VALUE);

		private int orbLevel;

		private OrbConsumption(int orbLevel) {
			this.orbLevel = orbLevel;
		}

		public int getOrbLevel() {
			return orbLevel;
		}

		public static boolean isLevelConsumed(ItemStack itemStack, OrbConsumption orbLevel) {
			if (itemStack.getItem() instanceof IBloodOrb)
				if (((IBloodOrb) itemStack.getItem()).getOrbLevel(itemStack.getMetadata()) < orbLevel.getOrbLevel())
					return true;
			return false;
		}

	}
}
