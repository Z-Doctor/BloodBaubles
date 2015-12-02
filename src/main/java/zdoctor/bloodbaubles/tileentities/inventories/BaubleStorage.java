package zdoctor.bloodbaubles.tileentities.inventories;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class BaubleStorage extends TileEntity implements IInventory {
  protected int inventorySize;
  protected String inventoryName;
  protected String customName;
  
  protected List<ItemStack> inventory;
  
  public BaubleStorage(int baseSize) {
    this.inventorySize = baseSize;
  }
  
  public void setInventoryName(String newInventoryName) {
    this.inventoryName = newInventoryName;
  }
  
  @Override
  public int getSizeInventory() {
    return this.inventorySize;
  }
  
  @Override
  public ItemStack getStackInSlot(int index) {
    try {
      return this.inventory.get(index);
    } catch (Exception e) {
      return null;
    }
    
  }
  
  @Override
  public ItemStack decrStackSize(int index, int count) {
    if (this.getStackInSlot(index) != null) {
      ItemStack itemStack;
      if (this.getStackInSlot(index).stackSize <= count) {
        itemStack = this.getStackInSlot(index);
        this.setInventorySlotContents(index, null);
        this.markDirty();
        return itemStack;
      } else {
        itemStack = this.getStackInSlot(index).splitStack(count);
        if (this.getStackInSlot(index).stackSize <= 0) {
          this.setInventorySlotContents(index, null);
        } else {
          this.setInventorySlotContents(index, this.getStackInSlot(index));
        }
        this.markDirty();
        return itemStack;
      }
    }
    return null;
  }
  
  @Override
  public ItemStack getStackInSlotOnClosing(int index) {
    ItemStack itemStack = this.getStackInSlot(index);
    this.setInventorySlotContents(index, null);
    return itemStack;
  }
  
  @Override
  public void setInventorySlotContents(int index, ItemStack itemStack) {
    if (index < 0 || index > this.getSizeInventory()) {
      return;
    }
    if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
      itemStack.stackSize = this.getInventoryStackLimit();
    }
    if (itemStack != null && itemStack.stackSize == 0) {
      itemStack = null;
    }
    this.inventory.set(index, itemStack);
    this.markDirty();
  }
  
  @Override
  public String getInventoryName() {
    return this.hasCustomInventoryName() ? this.customName : this.inventoryName;
  }
  
  @Override
  public boolean hasCustomInventoryName() {
    return this.customName != null && !this.customName.equals("");
  }
  
  @Override
  public int getInventoryStackLimit() {
    // TODO Auto-generated method stub
    return 0;
  }
  
  @Override
  public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
    // TODO Auto-generated method stub
    return false;
  }
  
  @Override
  public void openInventory() {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public void closeInventory() {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
    // TODO Auto-generated method stub
    return false;
  }
}