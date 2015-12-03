package zdoctor.bloodbaubles.common.events.custom;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ChunkEvent;

public class CustomEvents {
  public CustomEvents() {
    MinecraftForge.EVENT_BUS.register(new CustomEvents.ForgeEvents());
    FMLCommonHandler.instance().bus().register(new CustomEvents.FMLEventss());
  }
  public static class ForgeEvents {
    @SubscribeEvent
    public void chunkLoaded(ChunkEvent.Load e) {
      if(TECountChanged.lastCount != e.world.loadedTileEntityList.size()) {
        MinecraftForge.EVENT_BUS.post(new TECountChanged(e.world.loadedTileEntityList, TECountChanged.lastCount));
        TECountChanged.lastCount = e.world.loadedTileEntityList.size();
      }
    }
  }

  public static class FMLEventss {
  }
}
