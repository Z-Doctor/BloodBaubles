package zdoctor.bloodbaubles.client.render;

import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;

import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipe;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import WayofTime.alchemicalWizardry.api.soulNetwork.SoulNetworkHandler;
import WayofTime.alchemicalWizardry.api.tile.IBloodAltar;
import WayofTime.alchemicalWizardry.common.tileEntity.TEAltar;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import zdoctor.bloodbaubles.common.ZPendants;
import zdoctor.bloodbaubles.common.baubles.pendants.PendantSeerPendant;
import zdoctor.bloodbaubles.common.events.custom.RenderAltarInfoEvent;
import zdoctor.bloodbaubles.common.helpers.LocatingHelpers;
import zdoctor.bloodbaubles.common.helpers.RenderHelper;
import zdoctor.bloodbaubles.common.helpers.VectorHelper;
import zdoctor.bloodbaubles.world.data.Data;

public class GuiAltarInfo {
  @SideOnly(Side.CLIENT)
  public static void render() {
    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
    if(player != null) {
      InventoryBaubles inventory = PlayerHandler.getPlayerBaubles(player);
      ItemStack iStack = inventory.getStackInSlot(0);
      if(iStack != null && iStack.isItemEqual(new ItemStack(ZPendants.PendantSeerPendant))) {
        int scanRadius = ((PendantSeerPendant) iStack.getItem()).getScanRadius();
        List teList = LocatingHelpers.findAllTileEntitiesAround(player, scanRadius);
        Iterator iterator = teList.iterator();
        while(iterator.hasNext()) {
          Object te = iterator.next();
          if(te instanceof IBloodAltar) {
            Event render = new RenderAltarInfoEvent((TEAltar) te, player);
            MinecraftForge.EVENT_BUS.post(render);
            if(!render.isCanceled())
              renderData((TEAltar) te);
          }
        }
      }
    }

  }

  @SideOnly(Side.CLIENT)
  public static void renderData(TEAltar clientAltar) {
    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
    InventoryBaubles inventory = PlayerHandler.getPlayerBaubles(player);
    if (inventory.getStackInSlot(0) != null
        && inventory.getStackInSlot(0).isItemEqual(new ItemStack(ZPendants.PendantSeerPendant))) {
      PendantSeerPendant pendnant = (PendantSeerPendant) inventory.getStackInSlot(0).getItem();
      if (VectorHelper.entityWithinDist(clientAltar.xCoord, clientAltar.yCoord, clientAltar.zCoord, player, 10)) {
        TEAltar serverAltar = (TEAltar) Data.theServerWorld.getTileEntity(clientAltar.xCoord, clientAltar.yCoord, clientAltar.zCoord);
        if(serverAltar != null) {
          GL11.glPushMatrix(); // 0
          RenderHelper.applyTETranslatef(clientAltar, 0.5f, 1.75f, 0.5f);
          RenderHelper.applyFloatingRotations();
          GL11.glRotatef(180f, 0, 0, 1f);

          GL11.glPushMatrix(); // 1
          GL11.glScalef(0.025f, 0.025f, 0.025f);
          RenderHelper.renderText(getBloodData(serverAltar), 0);
          GL11.glPopMatrix(); // 1

          GL11.glPushMatrix(); // 2
          GL11.glTranslatef(0f, 0.25f, 0f);
          GL11.glScalef(0.025f, 0.025f, 0.025f);
          RenderHelper.renderText("Tier: " + (serverAltar.getTier() <= 1 ? "1" : serverAltar.getTier()), Integer.parseInt("00AAAA", 16));
          GL11.glPopMatrix(); // 2

          if (serverAltar.getStackInSlot(0) != null) {
            GL11.glPushMatrix(); // 3
            GL11.glTranslatef(0f, 0.5f, 0f);
            GL11.glScalef(0.025f, 0.025f, 0.025f);
            RenderHelper.renderText(getAltarProgress(serverAltar), Integer.parseInt("AA0000", 16));
            GL11.glPopMatrix(); // 3
          }
          GL11.glPopMatrix(); // 0
        }
      }
    }
  }

  public static String getBloodData(TEAltar altar) {
    return altar.getCurrentBlood() + "LP/" + altar.getCapacity() + "LP";
  }

  public static String getAltarProgress(TEAltar altar) {
    AltarRecipe recipe = AltarRecipeRegistry.getAltarRecipeForItemAndTier(altar.getStackInSlot(0), altar.getTier());

    if (altar.getStackInSlot(0).getItem() instanceof IBloodOrb) {
      ItemStack iStack = altar.getStackInSlot(0);
      String owner = SoulNetworkHandler.getOwnerName(iStack);
      IBloodOrb orb = (IBloodOrb) iStack.getItem();
      if (owner.equals(""))
        return "No Owner";
      else if (orb.getOrbLevel() > (altar.getTier() == 0 ? 1 : altar.getTier()))
        return "Upgrade to Tier " + orb.getOrbLevel() + " to charge orb.";
      else
        return SoulNetworkHandler.getCurrentEssence(owner) + "LP/"
            + SoulNetworkHandler.getMaximumForOrbTier(SoulNetworkHandler.getCurrentMaxOrb(owner)) + "LP";
    } else if (recipe == null)
      return "???";
    int liquidRequired = recipe.getLiquidRequired();
    int progress = altar.getProgress();
    if(altar.isActive())
      return progress + "LP/" + liquidRequired + "LP";
    else
      return "Inactive";
  }
}
