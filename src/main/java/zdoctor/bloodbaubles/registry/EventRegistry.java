package zdoctor.bloodbaubles.registry;

import java.util.ArrayList;

import zdoctor.bloodbaubles.api.ISubEvent;
import zdoctor.bloodbaubles.events.SubEvent;

public class EventRegistry {
	private static final ArrayList<SubEvent> REGISTRY = new ArrayList<>();

	public static void registerEvent(SubEvent event) {
		System.out.println("RegisterEvent");
		REGISTRY.add(event);
	}

	public static void registerEvents() {
		REGISTRY.forEach((event) -> {
			event.registerEvent();
		});
		
		BaubleRegistry.REGISTRY.forEach((bauble) -> {
			if (bauble instanceof ISubEvent)
				REGISTRY.forEach((event) -> {
					event.registerSub(bauble);
				});
		});
	};

	// public static class events {
	// @SubscribeEvent(receiveCanceled = false)
	// public void deathEvent(LivingHurtEvent e) {
	// if (e.getEntity() instanceof EntityPlayer && e.isCancelable()) {
	// if (e.getEntityLiving().getHealth() - e.getAmount() <= 0) {
	// InventoryBaubles baubles = PlayerHandler.getPlayerBaubles((EntityPlayer)
	// e.getEntity());
	// for (int i = 0; i < baubles.getSizeInventory(); i++) {
	// if (baubles.getStackInSlot(i) != null
	// && baubles.getStackInSlot(i).isItemEqual(new ItemStack(ZRing.GodsGift, 1,
	// 1))) {
	// baubles.stackList[i] = new ItemStack(ZRing.GodsGift, 1, 0);
	// e.setCanceled(true);
	// e.getEntityLiving().heal(e.getEntityLiving().getMaxHealth());
	// break;
	// }
	// }
	// }
	// }
	// }
	//
	// @SubscribeEvent(receiveCanceled = false)
	// public void syphonEvent(ItemDrainNetworkEvent e) {
	// EntityPlayer player = PlayerHelper.getPlayerFromUUID(e.ownerUUID);
	// if (!player.capabilities.isCreativeMode) {
	// InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(player);
	// SoulNetwork soulNetwork = NetworkHelper.getSoulNetwork(player);
	// if(soulNetwork.getCurrentEssence() < e.syphon) {
	// for (int i = 0; i < baubles.getSizeInventory(); i++) {
	// if (baubles.getStackInSlot(i) != null
	// && baubles.getStackInSlot(i).getItem() instanceof EssenceRing
	// && e.syphon > 0) {
	// EssenceRing ring = (EssenceRing) baubles.stackList[i].getItem();
	// int diff = e.syphon - soulNetwork.getCurrentEssence();
	// soulNetwork.syphon(soulNetwork.getCurrentEssence());
	// e.syphon = ring.channelReserves(player, baubles.stackList[i], diff);
	// }
	// }
	// e.damageAmount = (float) e.syphon / 100.0f;
	// }
	// }
	// }
	//
	//// @SubscribeEvent
	//// public void itemCrafted(ItemCraftedEvent e) {
	//// if (e.crafting.getItem() instanceof RingEssence) {
	//// for (int i = 0; i < e.craftMatrix.getSizeInventory(); i++) {
	//// if (e.craftMatrix.getStackInSlot(i) != null
	//// && e.craftMatrix.getStackInSlot(i).getItem() instanceof IBloodOrb) {
	//// e.craftMatrix.setInventorySlotContents(i, null);
	//// break;
	//// }
	//// }
	//// }
	//// }
	// }
	//

}
