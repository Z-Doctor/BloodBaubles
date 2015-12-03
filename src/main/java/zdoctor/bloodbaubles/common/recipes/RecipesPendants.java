package zdoctor.bloodbaubles.common.recipes;

import WayofTime.alchemicalWizardry.api.items.ShapedBloodOrbRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import zdoctor.bloodbaubles.common.ZPendants;
import zdoctor.bloodbaubles.common.baubles.pendants.PendantSeerPendant;

public class RecipesPendants {
  public static void init() {
    GameRegistry.addRecipe(new ShapedBloodOrbRecipe(ZPendants.PendantSeerPendant, PendantSeerPendant.recipe));
  }
}
