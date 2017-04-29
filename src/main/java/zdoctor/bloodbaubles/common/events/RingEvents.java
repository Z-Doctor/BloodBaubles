package zdoctor.bloodbaubles.common.events;

import WayofTime.bloodmagic.api.event.SoulNetworkEvent.ItemDrainNetworkEvent;
import WayofTime.bloodmagic.api.saving.SoulNetwork;
import WayofTime.bloodmagic.api.util.helper.NetworkHelper;
import WayofTime.bloodmagic.api.util.helper.PlayerHelper;
import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zdoctor.bloodbaubles.common.ZBaubles;
import zdoctor.bloodbaubles.common.baubles.EssenceRing;

public class RingEvents {
	public static void postInit() {
		MinecraftForge.EVENT_BUS.register(new Events());
	}

	private static class Events {
		@SubscribeEvent(receiveCanceled = false)
		public void deathEvent(LivingHurtEvent e) {
			if (e.getEntity() instanceof EntityPlayer && e.isCancelable()) {
				if (e.getEntityLiving().getHealth() - e.getAmount() <= 0) {
					IBaublesItemHandler baubles = BaublesApi.getBaublesHandler((EntityPlayer) e.getEntity());
					for (int i = 0; i < baubles.getSlots(); i++) {
						if (!(baubles.getStackInSlot(i) == null || baubles.getStackInSlot(i).isEmpty())
								&& baubles.getStackInSlot(i).isItemEqual(new ItemStack(ZBaubles.GodsGift, 1, 1))) {
							baubles.setStackInSlot(i, new ItemStack(ZBaubles.GodsGift, 1, 0));
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
			if (player != null && !player.capabilities.isCreativeMode) {
				IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
				SoulNetwork soulNetwork = NetworkHelper.getSoulNetwork(player);
				if (soulNetwork.getCurrentEssence() < e.syphon) {
					for (int i = 0; i < baubles.getSlots(); i++) {
						if (!(baubles.getStackInSlot(i) == null || baubles.getStackInSlot(i).isEmpty())
								&& baubles.getStackInSlot(i).getItem() instanceof EssenceRing && e.syphon > 0) {
							EssenceRing ring = (EssenceRing) baubles.getStackInSlot(i).getItem();
							int diff = e.syphon - soulNetwork.getCurrentEssence();
							soulNetwork.syphon(soulNetwork.getCurrentEssence());
							e.syphon = ring.channelReserves(player, baubles.getStackInSlot(i), diff);
						}
					}
					e.damageAmount = (float) e.syphon / 100.0f;
				}
			}
		}
	}
}