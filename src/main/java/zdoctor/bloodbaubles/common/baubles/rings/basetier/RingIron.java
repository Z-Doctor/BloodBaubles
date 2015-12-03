package zdoctor.bloodbaubles.common.baubles.rings.basetier;

import java.util.List;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import zdoctor.bloodbaubles.ModMain;
import zdoctor.bloodbaubles.common.CTabs;

public class RingIron extends Item implements IBauble {
  public static final Object[] recipe = {" i ", "i i", " i ", 'i', Items.iron_ingot};
  
  public RingIron() {
    this.setMaxStackSize(1);
    this.setCreativeTab(CTabs.BloodRings);
    this.setUnlocalizedName(ModMain.MODID + "_BasicIronRing");
    this.setTextureName(ModMain.MODID + ":IronRing");
  }
  
  @Override
  public ItemStack onItemRightClick(ItemStack iStack, World world, EntityPlayer player) {
    if (!world.isRemote && !player.isSneaking()) {
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
  public void addInformation(ItemStack iStack, EntityPlayer player, List list, boolean var4) {
    super.addInformation(iStack, player, list, var4);
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
