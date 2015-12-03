package zdoctor.bloodbaubles.common.recipes;

import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.common.ZRings;

public class RecipesAltar {
  public static void init() {
    AltarRecipeRegistry.registerAltarRecipe(new ItemStack(ZRings.RingGodsGift, 1, 1), new ItemStack(ZRings.RingGodsGift, 1, 0), 1, 150000, 5, 1, false);
  }
}
