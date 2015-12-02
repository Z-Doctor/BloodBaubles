package zdoctor.bloodbaubles.api;

import net.minecraft.item.ItemStack;

public interface IRemember {
  public ItemStack remember(ItemStack iStack, String key, String str);

  public ItemStack remember(ItemStack iStack, String key, int i);

  public ItemStack remember(ItemStack iStack, String key, boolean b);

  public String recallString(ItemStack iStack, String key);

  public int recallInt(ItemStack iStack, String key);

  public boolean recallBoolean(ItemStack iStack, String key);
}
