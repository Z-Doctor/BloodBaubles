package zdoctor.bloodbaubles.common.baubles.rings.mastertier;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import zdoctor.bloodbaubles.ModMain;
import zdoctor.bloodbaubles.api.IChargeable;
import zdoctor.bloodbaubles.common.ZRings;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.RingGold;

public class RingGodsGift extends RingGold implements IChargeable {
  public static Object[] recipe = {"n", "g", 'n', Items.nether_star, 'g', ZRings.RingGoldRing};
  protected IIcon[] icons = new IIcon[2];
  
  public RingGodsGift() {
    super();
    this.setUnlocalizedName(ModMain.MODID + "_GodsGift");
    this.setHasSubtypes(true);
    
  }
  
  @Override
  public IIcon getIconFromDamage(int meta) {
    if (meta > 1)
      meta = 1;
    return this.icons[meta];
  }
  
  @Override
  public void getSubItems(Item item, CreativeTabs tab, List list) {
    list.add(new ItemStack(item, 1, 0));
    list.add(new ItemStack(item, 1, 1));
  }
  
  @Override
  public void registerIcons(IIconRegister reg) {
    this.icons[0] = reg.registerIcon(ModMain.MODID + ":GodsGiftInactive");
    this.icons[1] = reg.registerIcon(ModMain.MODID + ":GodsGiftActive");
  }
  
  @Override
  public void addInformation(ItemStack iStack, EntityPlayer player, List list, boolean par4) {
    if (iStack.getItemDamage() >= 1)
      list.add(StatCollector.translateToLocal("Active"));
    else
      list.add(StatCollector.translateToLocal("Inactive"));
  }
  
  @Override
  public boolean charge(int add) {
    System.out.println("Charging");
    return true;
  }
}
