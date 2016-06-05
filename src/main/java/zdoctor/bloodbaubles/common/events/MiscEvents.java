package zdoctor.bloodbaubles.common.events;

import net.minecraftforge.common.MinecraftForge;

public class MiscEvents {
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new Events());
	}

	private static class Events {
		// We'll see if I need this
		// @SubscribeEvent
		// public void worldLoaded(WorldEvent.Load e) {
		// if(e.getWorld().isRemote)
		// Data.theClientWorld = e.world;
		// else
		// Data.theServerWorld = e.world;
		// }

		// @SubscribeEvent
		// public void blockPlaced(BlockEvent.PlaceEvent e) {
		// if(Block.isEqualTo(e.getPlacedBlock().getBlock(), ModBlocks.altar) &&
		// !e.getWorld().isRemote)
		// e.world.markBlockForUpdate(e.x, e.y, e.z);
		// }
	}
}
