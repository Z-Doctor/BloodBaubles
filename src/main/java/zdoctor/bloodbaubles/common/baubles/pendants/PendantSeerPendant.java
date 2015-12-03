package zdoctor.bloodbaubles.common.baubles.pendants;

import java.util.List;

import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.common.tileEntity.TEAltar;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zdoctor.bloodbaubles.ModMain;
import zdoctor.bloodbaubles.common.CTabs;
import zdoctor.bloodbaubles.common.helpers.LocatingHelpers;

public class PendantSeerPendant extends Item implements IBauble {
  public static final Object[] recipe = new Object[] {
      " x ", "x x", " s ", 'x', Items.string, 's', ModItems.itemSeerSigil
  };

  protected static int defualtScanRadius = 10;
  protected int scanRadius;

  public List<TEAltar> nearbyAltars;

  public PendantSeerPendant() {
    this(defualtScanRadius);
  }

  public PendantSeerPendant(int scan) {
    super();
    this.maxStackSize = 1;
    this.setCreativeTab(CTabs.BloodRings);
    this.setUnlocalizedName(ModMain.MODID + "_SeerPendant");
    this.setTextureName(ModMain.MODID + ":SeerPendant");
    this.scanRadius = scan;
  }

  public int getScanRadius() {
    return this.scanRadius;
  }

  @Override
  public ItemStack onItemRightClick(ItemStack iStack, World world, EntityPlayer player) {
    if (!world.isRemote) {
      if (!player.isSneaking()) {
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
    }
    return iStack;
  }

  @Override
  public BaubleType getBaubleType(ItemStack itemstack) {
    return BaubleType.AMULET;
  }

  @Override
  public void onWornTick(ItemStack itemstack, EntityLivingBase player) {}

  @Override
  public void onEquipped(ItemStack itemstack, EntityLivingBase player) {}

  @Override
  public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {}

  @Override
  public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
    return true;
  }

  @Override
  public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
    return true;
  }

}
