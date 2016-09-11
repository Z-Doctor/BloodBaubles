package zdoctor.bloodbaubles.baubles.rings;

import java.util.List;

import WayofTime.bloodmagic.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.References;
import zdoctor.bloodbaubles.api.IAutoRecipe;
import zdoctor.bloodbaubles.baubles.EssenceBloodRing;
import zdoctor.bloodbaubles.enums.EnumRingMaterial;
import zdoctor.bloodbaubles.helpers.EssenceHelper;
import zdoctor.bloodbaubles.helpers.SoulForgeRecipeHelper;
import zdoctor.bloodbaubles.init.Rings;

public class WeakEssenceRing extends EssenceBloodRing {
  private int[] cost = new int[]{15, 75, 250, 625, 1025};
  public WeakEssenceRing() {
    super(References.WEAKESSENCE, ModItems.orbWeak);
  }

  @Override
  public int getCost(Integer meta) {
    return this.cost[meta];
  }

}
