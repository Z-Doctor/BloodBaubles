package zdoctor.bloodbaubles.common.baubles.rings.mastertier;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.ModMain;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.RingGold;
import WayofTime.alchemicalWizardry.api.soulNetwork.SoulNetworkHandler;

public class RingZDoctors extends RingGold {
  protected int cost = 1;
  
  public RingZDoctors() {
    super();
    this.setUnlocalizedName(ModMain.MODID + "_ZDcotorsRing");
    this.setTextureName(ModMain.MODID + ":ZDcotorsRing");
  }
  
  @Override
  public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
    if (!player.worldObj.isRemote) {
      if (SoulNetworkHandler.getCurrentEssence(player.getCommandSenderName()) > 0 || ((EntityPlayer) player).capabilities.isCreativeMode) {
        player.worldObj.provider.setWorldTime(player.worldObj.getWorldTime() - 1);
        SoulNetworkHandler.setCurrentEssence(player.getCommandSenderName(), SoulNetworkHandler.getCurrentEssence(player.getCommandSenderName()) - 1);
      }
    }
  }
}
