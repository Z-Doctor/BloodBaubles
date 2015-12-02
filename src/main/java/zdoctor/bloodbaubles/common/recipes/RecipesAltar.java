package zdoctor.bloodbaubles.common.recipes;

import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.common.ZRings;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;

public class RecipesAltar {
  public static void init() {
    AltarRecipeRegistry.registerAltarRecipe(new ItemStack(ZRings.RingGodsGift, 1, 1), new ItemStack(ZRings.RingGodsGift, 1, 0), 1, 350000, 75, 1, false);
  }
}
