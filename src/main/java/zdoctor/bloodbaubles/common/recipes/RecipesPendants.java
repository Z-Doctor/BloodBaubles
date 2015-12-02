package zdoctor.bloodbaubles.common.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.common.ZPendants;
import zdoctor.bloodbaubles.common.baubles.pendants.PendantSeerPendant;

public class RecipesPendants {
  public static void init() {
    GameRegistry.addRecipe(new ItemStack(ZPendants.PendantSeerPendant), PendantSeerPendant.recipe);
  }
}
