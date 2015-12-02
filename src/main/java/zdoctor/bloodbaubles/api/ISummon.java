package zdoctor.bloodbaubles.api;

import net.minecraft.item.ItemStack;

public interface ISummon {
  /**
   * This method returns the type of entity this is. Type is used to determine
   * for convenience.
   */
  public SummonType getSummonType(ItemStack stack);
  
  /**
	 * 
	 * 
	 */
  public boolean summon(ItemStack stack);
  
  public void banish(ItemStack stack);
  
  public boolean canSummonAt();
  
  public void onFailSummon(ItemStack stack);
  
  public void onSuccessfulSummon(ItemStack stack);
}
