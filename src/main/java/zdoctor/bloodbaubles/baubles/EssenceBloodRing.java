package zdoctor.bloodbaubles.baubles;

import java.util.List;

import WayofTime.bloodmagic.api.orb.BloodOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import zdoctor.bloodbaubles.api.IAutoRecipe;
import zdoctor.bloodbaubles.api.events.ISubLPDrain;
import zdoctor.bloodbaubles.enums.EnumRingMaterial;
import zdoctor.bloodbaubles.helpers.BaubleHelper;
import zdoctor.bloodbaubles.helpers.EssenceHelper;
import zdoctor.bloodbaubles.helpers.SoulForgeRecipeHelper;
import zdoctor.bloodbaubles.helpers.SoulNetworkHelper;
import zdoctor.bloodbaubles.init.Rings;
import zdoctor.bloodbaubles.token.NetworkDrainToken;

public abstract class EssenceBloodRing extends MaterialBloodRing
    implements
      ISubLPDrain,
      IAutoRecipe {

  private BloodOrb bloodOrb;

  public EssenceBloodRing(String nameIn, BloodOrb orb) {
    super(nameIn);
    this.bloodOrb = orb;
  }

  public boolean isEmergencyReserve() {
    return true;
  }

  public int getMaxEssence(ItemStack itemStack) {
    EnumRingMaterial material = EnumRingMaterial.values()[itemStack
        .getMetadata()];
    return (int) (this.bloodOrb.getCapacity() * material.getMultiplier());
  }

  public abstract int getCost(Integer meta);

  @Override
  public void addInformation(ItemStack itemStackIn, EntityPlayer playerIn,
      List list, boolean var4) {
    EssenceHelper eH = new EssenceHelper(itemStackIn);
    list.add(eH.getCurrentEssence() + "/" + eH.getMaxEssence());
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn,
      World worldIn, EntityPlayer playerIn, EnumHand hand) {
    if (!worldIn.isRemote) {
      if (playerIn.isSneaking()) {
        EssenceHelper eH = new EssenceHelper(itemStackIn);
        if (!eH.isFull(itemStackIn)) {
          int drainedAmount = eH.attemptToFillFrom(playerIn);
          return new ActionResult(EnumActionResult.PASS, itemStackIn);
        }
      }
    }
    return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
  }

  @Override
  public void onEvent(NetworkDrainToken token) {
    if (!token.isCreative()) {
      SoulNetworkHelper sH = new SoulNetworkHelper(token.player);
      if (!sH.hasEnough(token.getDrainAmount()) || !this.isEmergencyReserve()) {
        BaubleHelper bH = new BaubleHelper(token.player);
        if (bH.isWearing(this)) {
          List<ItemStack> essenceRings = bH.getBaubleStacks(this);
          essenceRings.forEach((ringStack) -> {
            EssenceHelper eH = new EssenceHelper(ringStack);
            token.setDrain(eH.syphonFromReserve(token.getDrainAmount()));
          });
        }
      }

    }
  }

  @Override
  public void registerRecipe() {
    this.forEachVariant((meta, varName) -> {
      SoulForgeRecipeHelper reciperHelper = new SoulForgeRecipeHelper(this,
          meta);
      reciperHelper.addCompnents(Rings.BasicRing, meta);
      reciperHelper.setDrain(this.getCost(meta));
      reciperHelper.registerRecipe();
    });
  }

}
