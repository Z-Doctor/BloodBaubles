package zdoctor.bloodbaubles.client.render;

import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;

import WayofTime.bloodmagic.api.Constants;
import WayofTime.bloodmagic.api.altar.IBloodAltar;
import WayofTime.bloodmagic.api.orb.IBloodOrb;
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
			if (itemStackIn != null && itemStackIn.isItemEqual(new ItemStack(ZPendant.SeersPendant))) {
				int scanRadius = ((SeersPendant) itemStackIn.getItem()).getScanRadius();
				List teList = LocatingHelpers.findAllTileEntitiesAround(player, scanRadius);
				Iterator iterator = teList.iterator();
				while (iterator.hasNext()) {
					Object te = iterator.next();
					if (te instanceof IBloodAltar) {
						Event render = new RenderAltarInfoEvent((TileAltar) te, player);
						MinecraftForge.EVENT_BUS.post(render);
						if (!render.isCanceled())
							renderData((TileAltar) te);
					}
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public static void renderData(TileAltar clientAltar) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		InventoryBaubles inventory = PlayerHandler.getPlayerBaubles(player);
		if (inventory.getStackInSlot(0) != null
				&& inventory.getStackInSlot(0).isItemEqual(new ItemStack(ZPendant.SeersPendant))) {
			SeersPendant pendnant = (SeersPendant) inventory.getStackInSlot(0).getItem();
			if (VectorHelper.entityWithinDist(clientAltar.getPos().getX(), clientAltar.getPos().getY(),
					clientAltar.getPos().getZ(), player, 10)) {
				// TileAltar serverAltar = (TileAltar)
				// .getTileEntity(clientAltar.getPos().getX(),
				// clientAltar.getPos().getY(), clientAltar.getPos().getZ());
				if (clientAltar != null) {
					GL11.glPushMatrix(); // 0
					RenderHelper.applyTETranslatef(clientAltar, 0.5f, 1.75f, 0.5f);
					RenderHelper.applyFloatingRotations();
					GL11.glRotatef(180f, 0, 0, 1f);

					GL11.glPushMatrix(); // 1
					GL11.glScalef(0.025f, 0.025f, 0.025f);
					RenderHelper.renderText(getBloodData(clientAltar), 0);
					GL11.glPopMatrix(); // 1

					GL11.glPushMatrix(); // 2
					GL11.glTranslatef(0f, 0.25f, 0f);
					GL11.glScalef(0.025f, 0.025f, 0.025f);
					RenderHelper.renderText("Tier: " + clientAltar.getTier().toInt(), Integer.parseInt("00AAAA", 16));
					GL11.glPopMatrix(); // 2

					GL11.glPushMatrix(); // 3
					GL11.glTranslatef(0f, 0.5f, 0f);
					GL11.glScalef(0.025f, 0.025f, 0.025f);
					RenderHelper.renderText(getAltarProgress(clientAltar), Integer.parseInt("AA0000", 16));
					GL11.glPopMatrix(); // 3

					GL11.glPopMatrix(); // 0
				}
			}
		}
	}

	public static String getBloodData(TileAltar altar) {
		return altar.getCurrentBlood() + "LP/" + altar.getCapacity() + "LP";
	}

	public static String getAltarProgress(TileAltar altar) {
		if (altar.func_70301_a(0) != null) {
			ItemStack itemStack = altar.func_70301_a(0);
			if (altar.func_70301_a(0).getItem() instanceof IBloodOrb) {
				IBloodOrb orb = (IBloodOrb) itemStack.getItem();
				String owner = "No Owner";
				if (itemStack.getTagCompound() != null) {
					String uuid = itemStack.getTagCompound().getString(Constants.NBT.OWNER_UUID);
					owner = uuid.equals("") ? owner : uuid;
				}
				if (!owner.equals("No Owner")) {
					if (orb.getOrbLevel(itemStack.getMetadata()) > altar.getTier().toInt())
						return "Upgrade to Tier " + orb.getOrbLevel(itemStack.getMetadata()) + " to charge orb.";
					else {
						return PlayerHelper.getUsernameFromUUID(owner) + " orb charging.";
					}
				}
				return owner;
			} else {
				if (altar.isActive())
					return altar.getProgress() + "LP/" + altar.getLiquidRequired() + "LP";
				else
					return itemStack.getDisplayName();
			}
		}
		return "Inactive";
	}
}
