package zdoctor.bloodbaubles.common.events;

import WayofTime.bloodmagic.api.orb.IBloodOrb;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import zdoctor.bloodbaubles.api.IConsumeBloodOrb;

public class CraftingEvents {
	public static void postInit() {
		MinecraftForge.EVENT_BUS.register(new Events());
	}

	private static class Events {
		@SubscribeEvent
		public void itemCrafted(PlayerEvent.ItemCraftedEvent e) {
			if (e.crafting.getItem() instanceof IConsumeBloodOrb) {
				for (int i = 0; i < e.craftMatrix.getSizeInventory(); i++) {
					ItemStack stack = e.craftMatrix.getStackInSlot(i);
					if(!stack.getItem().hasContainerItem(stack) || stack.getItem() instanceof IBloodOrb)
						e.craftMatrix.setInventorySlotContents(i, ItemStack.EMPTY);
				}
			}
		}
	}
}
