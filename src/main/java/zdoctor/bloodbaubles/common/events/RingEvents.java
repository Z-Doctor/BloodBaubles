package zdoctor.bloodbaubles.common.events;

import WayofTime.bloodmagic.api.event.SoulNetworkEvent.ItemDrainNetworkEvent;
import WayofTime.bloodmagic.api.network.SoulNetwork;
import WayofTime.bloodmagic.api.util.helper.NetworkHelper;
import WayofTime.bloodmagic.api.util.helper.PlayerHelper;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zdoctor.bloodbaubles.common.ZRing;
import zdoctor.bloodbaubles.common.baubles.rings.essence.EssenceRing;

public class RingEvents {
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new Events());
	}

	private static class Events {
		@SubscribeEvent(receiveCanceled = false)
		public void deathEvent(LivingHurtEvent e) {
			if (e.getEntity() instanceof EntityPlayer && e.isCancelable()) {
				if (e.getEntityLiving().getHealth() - e.getAmount() <= 0) {
					InventoryBaubles baubles = PlayerHandler.getPlayerBaubles((EntityPlayer) e.getEntity());
					for (int i = 0; i < baubles.getSizeInventory(); i++) {
						if (baubles.getStackInSlot(i) != null
								&& baubles.getStackInSlot(i).isItemEqual(new ItemStack(ZRing.GodsGift, 1, 1))) {
							baubles.stackList[i] = new ItemStack(ZRing.GodsGift, 1, 0);
							e.setCanceled(true);
							e.getEntityLiving().heal(e.getEntityLiving().getMaxHealth());
							break;
						}
					}
				}
			}
		}

		@SubscribeEvent(receiveCanceled = false)
		public void syphonEvent(ItemDrainNetworkEvent e) {
			EntityPlayer player = PlayerHelper.getPlayerFromUUID(e.ownerUUID);
			if (!player.capabilities.isCreativeMode) {
				InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(player);
				SoulNetwork soulNetwork = NetworkHelper.getSoulNetwork(player);
				if (soulNetwork.getCurrentEssence() < e.syphon) {
					for (int i = 0; i < baubles.getSizeInventory(); i++) {
						if (baubles.getStackInSlot(i) != null
								&& baubles.getStackInSlot(i).getItem() instanceof EssenceRing && e.syphon > 0) {
							EssenceRing ring = (EssenceRing) baubles.stackList[i].getItem();
							int diff = e.syphon - soulNetwork.getCurrentEssence();
							soulNetwork.syphon(soulNetwork.getCurrentEssence());
							e.syphon = ring.channelReserves(player, baubles.stackList[i], diff);
						}
					}
					e.damageAmount = (float) e.syphon / 100.0f;
				}
			}
		}

		// @SubscribeEvent
		// public void itemCrafted(ItemCraftedEvent e) {
		// if (e.crafting.getItem() instanceof RingEssence) {
		// for (int i = 0; i < e.craftMatrix.getSizeInventory(); i++) {
		// if (e.craftMatrix.getStackInSlot(i) != null
		// && e.craftMatrix.getStackInSlot(i).getItem() instanceof IBloodOrb) {
		// e.craftMatrix.setInventorySlotContents(i, null);
		// break;
		// }
		// }
		// }
		// }
	}
}
