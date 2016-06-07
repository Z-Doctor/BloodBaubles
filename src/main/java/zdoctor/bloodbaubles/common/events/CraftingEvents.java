package zdoctor.bloodbaubles.common.events;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import zdoctor.bloodbaubles.api.IConsumeBloodOrb;

public class CraftingEvents {
	public static void postInit() {
		MinecraftForge.EVENT_BUS.register(new Events());
	}

	private static class Events {
		@SubscribeEvent
		public void itemCrafted(ItemCraftedEvent e) {
			if (e.crafting.getItem() instanceof IConsumeBloodOrb) {
				for (int i = 0; i < e.craftMatrix.getSizeInventory(); i++) {
					e.craftMatrix.setInventorySlotContents(i, null);
				}
			}
		}
	}
}
