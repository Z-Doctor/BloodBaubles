package zdoctor.bloodbaubles.client;

import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;

import WayofTime.bloodmagic.api.orb.IBloodOrb;
import WayofTime.bloodmagic.api.saving.SoulNetwork;
import WayofTime.bloodmagic.api.util.helper.NBTHelper;
import WayofTime.bloodmagic.api.util.helper.NetworkHelper;
import WayofTime.bloodmagic.api.util.helper.PlayerHelper;
import WayofTime.bloodmagic.tile.TileAltar;
import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zdoctor.bloodbaubles.common.ZBaubles;
import zdoctor.bloodbaubles.common.baubles.SeersPendant;
import zdoctor.bloodbaubles.common.events.custom.RenderAltarInfoEvent;
import zdoctor.bloodbaubles.common.helpers.LocatingHelpers;
import zdoctor.bloodbaubles.common.helpers.RenderHelper;
import zdoctor.bloodbaubles.common.helpers.VectorHelper;

public class AltarInfo {
	@SideOnly(Side.CLIENT)
	public static void render() {
		EntityPlayer player = Minecraft.getMinecraft().player;
		if (player != null) {
			IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
			for (int i = 0; i < baubles.getSlots(); i++)
				if ((baubles.getStackInSlot(i) != null && !baubles.getStackInSlot(i).isEmpty())
						&& baubles.getStackInSlot(i).isItemEqual(new ItemStack(ZBaubles.SeersPendant))) {
					ItemStack itemStack = baubles.getStackInSlot(i);
					int scanRadius = ((SeersPendant) itemStack.getItem()).getScanRadius();

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
		EntityPlayer player = Minecraft.getMinecraft().player;
		if (clientAltar != null) {
			if (VectorHelper.entityWithinDist(clientAltar.getPos(), player.getPosition(), 10)) {
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

	public static String getBloodData(TileAltar altar) {
		return altar.getCurrentBlood() + " LP/" + altar.getCapacity() + "LP";
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
						return network.getCurrentEssence() + " LP/" + orb.getMaxEssence(itemStack.getMetadata()) + " LP";
					}
					return itemOwner + " Orb: " + orb.getMaxEssence(itemStack.getMetadata());
				}

				return ownerUUID;
			}
			
			if (altar.isActive()) {
				return altar.getProgress() + " LP/" + altar.getLiquidRequired() + " LP - DPS: "
						+ (altar.getConsumptionRate() + (1.0f + altar.getConsumptionMultiplier()));
			}
			
			return itemStack.getDisplayName().equalsIgnoreCase("air") ? "Empty" : itemStack.getDisplayName();
		}

		return altar.getConsumptionRate() + " LPDPS " + altar.getConsumptionMultiplier() + " LPMultiplier";
	}

	public static String getOwnerName(ItemStack stack) {
		return stack != null ? NBTHelper.checkNBT(stack).getTagCompound().getString("ownerNAME") : null;
	}
}