package zdoctor.bloodbaubles.client.render;

import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;

import WayofTime.bloodmagic.api.network.SoulNetwork;
import WayofTime.bloodmagic.api.orb.IBloodOrb;
import WayofTime.bloodmagic.api.util.helper.NBTHelper;
import WayofTime.bloodmagic.api.util.helper.NetworkHelper;
import WayofTime.bloodmagic.api.util.helper.PlayerHelper;
import WayofTime.bloodmagic.tile.TileAltar;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zdoctor.bloodbaubles.common.ZPendant;
import zdoctor.bloodbaubles.common.baubles.pendants.SeersPendant;
import zdoctor.bloodbaubles.common.events.custom.RenderAltarInfoEvent;
import zdoctor.bloodbaubles.common.helpers.LocatingHelpers;
import zdoctor.bloodbaubles.common.helpers.RenderHelper;
import zdoctor.bloodbaubles.common.helpers.VectorHelper;

public class GuiAltarInfo {
	@SideOnly(Side.CLIENT)
	public static void render() {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player != null) {
			InventoryBaubles inventory = PlayerHandler.getPlayerBaubles(player);
			ItemStack itemStackIn = inventory.getStackInSlot(0);
			if ((itemStackIn != null) && (itemStackIn.isItemEqual(new ItemStack(ZPendant.SeersPendant)))) {
				int scanRadius = ((SeersPendant) itemStackIn.getItem()).getScanRadius();

				List teList = LocatingHelpers.findTileEntitiesAround(player, scanRadius, TileAltar.class);
				Iterator iterator = teList.iterator();
				while (iterator.hasNext()) {
					TileAltar te = (TileAltar) iterator.next();
					Event render = new RenderAltarInfoEvent(te, player);
					MinecraftForge.EVENT_BUS.post(render);
					if (!render.isCanceled())
						renderData((TileAltar) te);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public static void renderData(TileAltar clientAltar) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		InventoryBaubles inventory = PlayerHandler.getPlayerBaubles(player);
		if ((inventory.getStackInSlot(0) != null)
				&& (inventory.getStackInSlot(0).isItemEqual(new ItemStack(ZPendant.SeersPendant)))) {
			SeersPendant pendnant = (SeersPendant) inventory.getStackInSlot(0).getItem();
			if (VectorHelper.entityWithinDist(clientAltar.getPos(), player.getPosition(), 10)) {

				if (clientAltar != null) {
					GL11.glPushMatrix();
					RenderHelper.applyTETranslatef(clientAltar, 0.5F, 1.75F, 0.5F);
					RenderHelper.applyFloatingRotations();
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);

					GL11.glPushMatrix();
					GL11.glScalef(0.025F, 0.025F, 0.025F);
					RenderHelper.renderText(getBloodData(clientAltar), 0);
					GL11.glPopMatrix();

					GL11.glPushMatrix();
					GL11.glTranslatef(0.0F, 0.25F, 0.0F);
					GL11.glScalef(0.025F, 0.025F, 0.025F);
					RenderHelper.renderText("Tier: " + clientAltar.getTier().toInt(), Integer.parseInt("00AAAA", 16));
					GL11.glPopMatrix();

					GL11.glPushMatrix();
					GL11.glTranslatef(0.0F, 0.5F, 0.0F);
					GL11.glScalef(0.025F, 0.025F, 0.025F);
					RenderHelper.renderText(getAltarProgress(clientAltar), Integer.parseInt("AA0000", 16));
					GL11.glPopMatrix();

					GL11.glPopMatrix();
				}
			}
		}
	}

	public static String getBloodData(TileAltar altar) {
		return altar.getCurrentBlood() + " LP / " + altar.getCapacity() + "LP";
	}

	public static String getAltarProgress(TileAltar altar) {
		if (altar.getStackInSlot(0) != null) {
			ItemStack itemStack = altar.getStackInSlot(0);
			if ((altar.getStackInSlot(0).getItem() instanceof IBloodOrb)) {
				IBloodOrb orb = (IBloodOrb) itemStack.getItem();
				String ownerUUID = "No Owner";
				if (itemStack.getTagCompound() != null) {
					String uuid = itemStack.getTagCompound().getString("ownerUUID");
					ownerUUID = uuid.equals("") ? ownerUUID : uuid;
				}
				if (!ownerUUID.equals("No Owner")) {
					if (orb.getOrbLevel(itemStack.getMetadata()) > altar.getTier().toInt()) {
						return "Upgrade to Tier " + orb.getOrbLevel(itemStack.getMetadata()) + " to charge orb.";
					}
					String ownerName = PlayerHelper.getUsernameFromUUID(ownerUUID);
					String itemOwner = getOwnerName(itemStack);
					if (ownerName.equals(itemOwner)) {
						SoulNetwork network = NetworkHelper.getSoulNetwork(ownerUUID);
						return network.getCurrentEssence() + ":" + network.getOrbTier();
					}
					return itemOwner + " Orb: " + orb.getMaxEssence(itemStack.getMetadata());
				}

				return ownerUUID;
			}
			if (altar.isActive()) {
				return altar.getProgress() + " LP / " + altar.getLiquidRequired() + " LP DPS: "
						+ altar.getConsumptionRate() + (1.0f + altar.getConsumptionMultiplier());
			}
			return itemStack.getDisplayName();
		}

		return altar.getConsumptionRate() + " LPDPS " + altar.getConsumptionMultiplier() + " LPMultiplier";
	}

	public static String getOwnerName(ItemStack stack) {
		return stack != null ? NBTHelper.checkNBT(stack).getTagCompound().getString("ownerNAME") : null;
	}
}
