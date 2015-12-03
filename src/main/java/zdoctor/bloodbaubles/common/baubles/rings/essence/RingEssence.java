package zdoctor.bloodbaubles.common.baubles.rings.essence;

import java.util.List;

import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import WayofTime.alchemicalWizardry.api.soulNetwork.SoulNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import zdoctor.bloodbaubles.api.IStoreLP;
import zdoctor.bloodbaubles.common.ZRings;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.RingIron;

public class RingEssence extends RingIron implements IStoreLP {
  protected int maxEssence;
  protected RingMaterial material;
  protected Item bloodOrb;
  
  public RingEssence(IBloodOrb bOrb, RingMaterial rMaterial) {
    this.maxEssence = (int) (bOrb.getMaxEssence() * this.getBonusEssense(rMaterial));
    this.material = rMaterial;
    this.bloodOrb = (Item) bOrb;
  }
  
  protected String getMaterialName(RingMaterial rMaterial) {
    if (rMaterial == RingMaterial.IRON)
      return "Iron";
    if (rMaterial == RingMaterial.GOLD)
      return "Gold";
    return "Iron";
  }
  
  protected Item getBaseRing(RingMaterial rMaterial) {
    if (rMaterial == RingMaterial.IRON)
      return ZRings.RingIronRing;
    if (rMaterial == RingMaterial.GOLD)
      return ZRings.RingGoldRing;
    return ZRings.RingIronRing;
  }
  
  protected float getBonusEssense(RingMaterial rMaterial) {
    if (rMaterial == RingMaterial.IRON)
      return 1f;
    else if (rMaterial == RingMaterial.GOLD)
      return 1.25f;
    
    return 1f;
  }
  
  public Object[] getRecipe() {
    Object[] recipe = {"o", "b", 'o', this.bloodOrb, 'b', this.getBaseRing(this.material)};
    return recipe;
  }
  
  @Override
  public ItemStack onItemRightClick(ItemStack iStack, World world, EntityPlayer player) {
    if (!world.isRemote) {
      if (player.isSneaking()) {
        if (!this.isFull(iStack)) {
          this.syphon(iStack, (EntityPlayer) player, this.getNeededLP(iStack));
        }
      }
      
    }
    return super.onItemRightClick(iStack, world, player);
  }
  
  @Override
  public void addInformation(ItemStack iStack, EntityPlayer player, List list, boolean var4) {
    list.add(StatCollector.translateToLocal(this.getStoredLP(iStack) + "/" + this.getMaxCapacity(iStack)));
  }
  
  @Override
  public int getStoredLP(ItemStack iStack) {
    if (iStack.getTagCompound() == null || !iStack.getTagCompound().hasKey("LPStored"))
      return 0;
    if (iStack.getTagCompound().getInteger("LPStored") < 0)
      iStack.getTagCompound().setInteger("LPStored", 0);
    return iStack.getTagCompound().getInteger("LPStored");
    
  }
  
  @Override
  public int getMaxCapacity(ItemStack iStack) {
    return this.maxEssence;
  }
  
  @Override
  public void syphon(ItemStack iStack, EntityPlayer player, int amountLP) {
    int pLP = SoulNetworkHandler.getCurrentEssence(player.getCommandSenderName());
    if (this.getNeededLP(iStack) > pLP)
      amountLP = pLP;
    SoulNetworkHandler.syphonAndDamageFromNetwork(player.getCommandSenderName(), player, amountLP);
    this.storeLP(iStack, amountLP);
    
  }
  
  @Override
  public void storeLP(ItemStack iStack, int amountLP) {
    if (iStack.getTagCompound() == null)
      iStack.setTagCompound(new NBTTagCompound());
    if (!iStack.getTagCompound().hasKey("LPStored"))
      iStack.getTagCompound().setInteger("LPStored", 0);
    iStack.getTagCompound().setInteger("LPStored", iStack.getTagCompound().getInteger("LPStored") + amountLP);
    if (iStack.getTagCompound().getInteger("LPStored") > this.maxEssence)
      iStack.getTagCompound().setInteger("LPStored", this.maxEssence);
  }
  
  @Override
  public int getNeededLP(ItemStack iStack) {
    return this.maxEssence - this.getStoredLP(iStack);
  }
  
  @Override
  public boolean isFull(ItemStack iStack) {
    return this.maxEssence == this.getStoredLP(iStack);
  }
  
  @Override
  public int drainLP(ItemStack iStack, int amountLP) {
    if (this.getStoredLP(iStack) > amountLP) {
      iStack.getTagCompound().setInteger("LPStored", this.getStoredLP(iStack) - amountLP);
      return 0;
    }
    amountLP -= this.getStoredLP(iStack);
    iStack.getTagCompound().setInteger("LPStored", 0);
    return amountLP;
    
  }
  
  public static enum RingMaterial {
    IRON, GOLD
  }
  
}
