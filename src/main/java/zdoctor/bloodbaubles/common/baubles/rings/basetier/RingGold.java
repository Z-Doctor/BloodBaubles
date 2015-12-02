package zdoctor.bloodbaubles.common.baubles.rings.basetier;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import zdoctor.bloodbaubles.ModMain;
import zdoctor.bloodbaubles.common.CTabs;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;

public class RingGold extends Item implements IBauble {
  public static Object[] recipe = {" g ", "g g", " g ", 'g', Items.gold_ingot};
  
  public RingGold() {
    this.setMaxStackSize(1);
    this.setCreativeTab(CTabs.BloodRings);
    this.setUnlocalizedName(ModMain.MODID + "_BasicGoldRing");
    this.setTextureName(ModMain.MODID + ":GoldRing");
  }
  
  @Override
  public ItemStack onItemRightClick(ItemStack iStack, World world, EntityPlayer player) {
    if (!world.isRemote) {
      InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(player);
      for (int i = 0; i < baubles.getSizeInventory(); i++) {
        if (baubles.getStackInSlot(i) == null && baubles.isItemValidForSlot(i, iStack)) {
          baubles.setInventorySlotContents(i, iStack.copy());
          if (!player.capabilities.isCreativeMode) {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
          }
          onEquipped(iStack, player);
          break;
        }
      }
    }
    return super.onItemRightClick(iStack, world, player);
  }
  
  @Override
  public BaubleType getBaubleType(ItemStack itemstack) {
    return BaubleType.RING;
  }
  
  @Override
  public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
    
  }
  
  @Override
  public void onEquipped(ItemStack iStack, EntityLivingBase player) {
    if (!player.worldObj.isRemote) {
      player.worldObj.playSoundAtEntity(player, "random.orb", 0.1F, 1.3F);
    }
  }
  
  @Override
  public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
    
  }
  
  @Override
  public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
    return true;
  }
  
  @Override
  public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
    return true;
  }
}
