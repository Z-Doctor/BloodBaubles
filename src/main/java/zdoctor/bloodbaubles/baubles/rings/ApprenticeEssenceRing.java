package zdoctor.bloodbaubles.baubles.rings;

import java.util.List;

import WayofTime.bloodmagic.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.References;
import zdoctor.bloodbaubles.api.IAutoRecipe;
import zdoctor.bloodbaubles.baubles.EssenceBloodRing;
import zdoctor.bloodbaubles.helpers.EssenceHelper;
import zdoctor.bloodbaubles.helpers.SoulForgeRecipeHelper;
import zdoctor.bloodbaubles.init.Rings;

public class ApprenticeEssenceRing extends EssenceBloodRing {
  private int[] cost = new int[]{50, 135, 350, 875, 1125};
  public ApprenticeEssenceRing() {
    super(References.APPRENTICE, ModItems.orbApprentice);
  }

  @Override
  public int getCost(Integer meta) {
    return this.cost[meta];
  }

}
