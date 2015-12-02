package zdoctor.bloodbaubles.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IStoreLP {
  public int getStoredLP(ItemStack iStack);
  
  public int getMaxCapacity(ItemStack iStack);
  
  public void syphon(ItemStack iStack, EntityPlayer player, int amountLP);
  
  public void storeLP(ItemStack iStack, int amountLP);
  
  public int getNeededLP(ItemStack iStack);
  
  public boolean isFull(ItemStack iStack);
  
  public int drainLP(ItemStack iStack, int amountLP);
  
}
