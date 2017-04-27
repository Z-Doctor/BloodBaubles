package zdoctor.bloodbaubles.common.events;

import net.minecraftforge.common.MinecraftForge;

public class RingEvents {
	public static void postInit() {
		MinecraftForge.EVENT_BUS.register(new Events());
	}

	private static class Events {
//		@SubscribeEvent(receiveCanceled = false)
//		public void deathEvent(LivingHurtEvent e) {
//			if (e.getEntity() instanceof EntityPlayer && e.isCancelable()) {
//				if (e.getEntityLiving().getHealth() - e.getAmount() <= 0) {
//					InventoryBaubles baubles = PlayerHandler.getPlayerBaubles((EntityPlayer) e.getEntity());
//					for (int i = 0; i < baubles.getSizeInventory(); i++) {
//						if (baubles.getStackInSlot(i) != null
//								&& baubles.getStackInSlot(i).isItemEqual(new ItemStack(ZRing.GodsGift, 1, 1))) {
//							baubles.stackList[i] = new ItemStack(ZRing.GodsGift, 1, 0);
//							e.setCanceled(true);
//							e.getEntityLiving().heal(e.getEntityLiving().getMaxHealth());
//							break;
//						}
//					}
//				}
//			}
		}

//		@SubscribeEvent(receiveCanceled = false)
//		public void syphonEvent(ItemDrainNetworkEvent e) {
//			EntityPlayer player = PlayerHelper.getPlayerFromUUID(e.ownerUUID);
//			if (!player.capabilities.isCreativeMode) {
//				InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(player);
//				SoulNetwork soulNetwork = NetworkHelper.getSoulNetwork(player);
//				if (soulNetwork.getCurrentEssence() < e.syphon) {
//					for (int i = 0; i < baubles.getSizeInventory(); i++) {
//						if (baubles.getStackInSlot(i) != null
//								&& baubles.getStackInSlot(i).getItem() instanceof EssenceRing && e.syphon > 0) {
//							EssenceRing ring = (EssenceRing) baubles.stackList[i].getItem();
//							int diff = e.syphon - soulNetwork.getCurrentEssence();
//							soulNetwork.syphon(soulNetwork.getCurrentEssence());
//							e.syphon = ring.channelReserves(player, baubles.stackList[i], diff);
//						}
//					}
//					e.damageAmount = (float) e.syphon / 100.0f;
//				}
//			}
//		}
//	}
}