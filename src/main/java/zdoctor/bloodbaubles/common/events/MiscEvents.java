package zdoctor.bloodbaubles.common.events;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import zdoctor.bloodbaubles.client.render.GuiAltarInfo;
import zdoctor.bloodbaubles.common.helpers.RenderHelper;
import zdoctor.bloodbaubles.world.data.Data;

public class MiscEvents {
  public MiscEvents() {
    MinecraftForge.EVENT_BUS.register(new MiscEvents.ForgeEvents());
    FMLCommonHandler.instance().bus().register(new MiscEvents.FMLEvents());
  }

  public static class ForgeEvents {
    @SubscribeEvent
    public void worldLoaded(WorldEvent.Load e) {
      if(e.world.isRemote)
        Data.theClientWorld = e.world;
      else
        Data.theServerWorld = e.world;
    }
  }

  public static class FMLEvents {}
}
