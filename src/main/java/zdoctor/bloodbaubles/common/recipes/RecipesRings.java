package zdoctor.bloodbaubles.common.recipes;

import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.common.ZRings;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.RingGold;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.RingIron;
import zdoctor.bloodbaubles.common.baubles.rings.essence.RingEssence;
import zdoctor.bloodbaubles.common.baubles.rings.mastertier.RingGodsGift;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesRings {
  public static void init() {
    GameRegistry.addRecipe(new ItemStack(ZRings.RingIronRing), RingIron.recipe);
    GameRegistry.addRecipe(new ItemStack(ZRings.RingGoldRing), RingGold.recipe);
    GameRegistry.addRecipe(new ItemStack(ZRings.RingGodsGift, 1, 0), RingGodsGift.recipe);
    GameRegistry.addRecipe(new ItemStack(ZRings.RingWeakIronBloodRing), ((RingEssence) ZRings.RingWeakIronBloodRing).getRecipe());
    GameRegistry.addRecipe(new ItemStack(ZRings.RingWeakGoldBloodRing), ((RingEssence) ZRings.RingWeakGoldBloodRing).getRecipe());
    GameRegistry.addRecipe(new ItemStack(ZRings.RingIronApprenticeRing), ((RingEssence) ZRings.RingIronApprenticeRing).getRecipe());
    GameRegistry.addRecipe(new ItemStack(ZRings.RingGoldApprenticeRing), ((RingEssence) ZRings.RingGoldApprenticeRing).getRecipe());
    GameRegistry.addRecipe(new ItemStack(ZRings.RingIronMagiciansRing), ((RingEssence) ZRings.RingIronMagiciansRing).getRecipe());
    GameRegistry.addRecipe(new ItemStack(ZRings.RingGoldMagiciansRing), ((RingEssence) ZRings.RingGoldMagiciansRing).getRecipe());
    GameRegistry.addRecipe(new ItemStack(ZRings.RingIronMasterRing), ((RingEssence) ZRings.RingIronMasterRing).getRecipe());
    GameRegistry.addRecipe(new ItemStack(ZRings.RingGoldMasterRing), ((RingEssence) ZRings.RingGoldMasterRing).getRecipe());
  }
}
