package zdoctor.bloodbaubles.world.data.bloodaltars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;

import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipe;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import WayofTime.alchemicalWizardry.api.soulNetwork.SoulNetworkHandler;
import WayofTime.alchemicalWizardry.common.block.BlockAltar;
import WayofTime.alchemicalWizardry.common.tileEntity.TEAltar;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zdoctor.bloodbaubles.common.ZPendants;
import zdoctor.bloodbaubles.common.baubles.pendants.PendantSeerPendant;
import zdoctor.bloodbaubles.common.helpers.RenderHelper;
import zdoctor.bloodbaubles.common.helpers.VectorHelper;

public class BloodAltarInfo {
  public static final List<BloodAltarInfo> altarList = new ArrayList<BloodAltarInfo>();
  protected TEAltar teAltar;
  protected BlockAltar blockAltar;

  protected World world;
  protected int posX;
  protected int posY;
  protected int posZ;

  protected int lastBlood;

  /**
   * To be used when loading up data.
   */
  public BloodAltarInfo() {}

  /**
   * Creates new info from given TEAltar
   */
  public BloodAltarInfo(TEAltar altar) {
    this(altar.getWorldObj(), altar.xCoord, altar.yCoord, altar.zCoord);
  }

  /**
   * Creates new info from a given coords and world
   */
  public BloodAltarInfo(World w, int x, int y, int z) {
    world = w;
    posX = x;
    posY = y;
    posZ = z;
    teAltar = (TEAltar) w.getTileEntity(x, y, z);
    blockAltar = (BlockAltar) world.getBlock(x, y, z);
    lastBlood = teAltar.getCurrentBlood();
  }

  /**
   * Used to notify altars to render info
   */
  @SideOnly(Side.CLIENT)
  public static void renderTick() {
    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
    Iterator<BloodAltarInfo> altars = altarList.iterator();
    while (altars.hasNext() && player != null) {
      altars.next().renderData(player);
    }
  }

  /**
   * Used to compare AltarInfos
   */
  public boolean isEqual(BloodAltarInfo info) {
    return this.teAltar == info.teAltar;
  }

  /**
   * The part that actually renders the data above altars
   */
  @SideOnly(Side.CLIENT)
  public void renderData(EntityPlayer player) {
    InventoryBaubles inventory = PlayerHandler.getPlayerBaubles(player);
    if (inventory.getStackInSlot(0) != null
        && inventory.getStackInSlot(0).isItemEqual(new ItemStack(ZPendants.PendantSeerPendant))) {
      PendantSeerPendant pendnant = (PendantSeerPendant) inventory.getStackInSlot(0).getItem();
      if (VectorHelper.entityWithinDist(this.posX, this.posY, this.posZ, player, 10)) {
        GL11.glPushMatrix(); // 0
          RenderHelper.applyTETranslatef((TileEntity) this.teAltar, 0.5f, 1.75f, 0.5f);
          RenderHelper.applyFloatingRotations();
          GL11.glRotatef(180f, 0, 0, 1f);

          GL11.glPushMatrix(); // 1
            GL11.glScalef(0.025f, 0.025f, 0.025f);
            RenderHelper.renderText(this.getBloodData(), 0);
          GL11.glPopMatrix(); // 1

          GL11.glPushMatrix();
            GL11.glTranslatef(0f, 0.25f, 0f);
            GL11.glScalef(0.025f, 0.025f, 0.025f);
            RenderHelper.renderText("Tier: " + (this.teAltar.getTier() <= 1 ? "1" : this.teAltar.getTier()), Integer.parseInt("00AAAA", 16));
          GL11.glPopMatrix();

          if (this.teAltar.getStackInSlot(0) != null) {
            GL11.glPushMatrix(); // 3
              GL11.glTranslatef(0f, 0.5f, 0f);
              GL11.glScalef(0.025f, 0.025f, 0.025f);
              RenderHelper.renderText(this.getAltarProgress(), Integer.parseInt("AA0000", 16));
            GL11.glPopMatrix(); // 3
          }
        GL11.glPopMatrix(); // 0
        this.lastBlood = this.teAltar.getCurrentBlood();
      }
    }
  }

  public String getBloodData() {
    return this.teAltar.getCurrentBlood() + "LP/" + this.teAltar.getCapacity() + "LP";
  }

  public String getAltarProgress() {
    AltarRecipe recipe = AltarRecipeRegistry.getAltarRecipeForItemAndTier(this.teAltar.getStackInSlot(0), this.teAltar.getTier());

    if(this.teAltar.getStackInSlot(0).getItem() instanceof IBloodOrb) {
      ItemStack iStack = this.teAltar.getStackInSlot(0);
      String owner = SoulNetworkHandler.getOwnerName(iStack);
      if(owner.equals(""))
        return "No Owner";
      else
        return SoulNetworkHandler.getCurrentEssence(owner) + "LP/" + SoulNetworkHandler.getMaximumForOrbTier(SoulNetworkHandler.getCurrentMaxOrb(owner));
    } else if (recipe == null)
      return "0LP/0LP";
    else if(this.teAltar.getCurrentBlood() <= 0)
      return "No LP";
    int liquidRequired = recipe.getLiquidRequired();
    return this.teAltar.getProgress() + "LP/" + liquidRequired + "LP";
  }

  public int getDPS() {
    return this.teAltar.getCurrentBlood() - this.lastBlood;
  }

  public static BloodAltarInfo findAndRemoveAltar(BloodAltarInfo brokenAltar) {
    for (int i = 0; i < altarList.size(); i++) {
      if (altarList.get(i).isEqual(brokenAltar)) {
        return altarList.remove(i);
      }
    }
    return null;
  }
}