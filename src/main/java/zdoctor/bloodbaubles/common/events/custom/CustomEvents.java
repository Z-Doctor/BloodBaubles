package zdoctor.bloodbaubles.common.events.custom;

import net.minecraftforge.common.MinecraftForge;

public class CustomEvents {
  public static void init() {
    MinecraftForge.EVENT_BUS.register(new Events());
  }
  public static class Events {
		// @SubscribeEvent
		// public void chunkLoaded(ChunkEvent.Load e) {
		// if(TECountChanged.lastCount != e.world.loadedTileEntityList.size()) {
		// MinecraftForge.EVENT_BUS.post(new
		// TECountChanged(e.world.loadedTileEntityList,
		// TECountChanged.lastCount));
		// TECountChanged.lastCount = e.world.loadedTileEntityList.size();
		// }
		// }
  }

  public static class FMLEventss {
  }
}
