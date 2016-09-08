package zdoctor.bloodbaubles.registry;

import java.util.ArrayList;

import zdoctor.bloodbaubles.api.events.ISubEvent;
import zdoctor.bloodbaubles.events.SubEvent;

public class EventRegistry {
	private static final ArrayList<SubEvent> REGISTRY = new ArrayList<>();

	public static void registerEvent(SubEvent event) {
		REGISTRY.add(event);
	}
	
	public static void registerSubscibers() {
		BaubleRegistry.REGISTRY.forEach((bauble) -> {
			if (bauble instanceof ISubEvent) {
				REGISTRY.forEach((event) -> {
					event.registerSub((ISubEvent)bauble);
				});
			}
		});
	}

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
