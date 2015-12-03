package zdoctor.bloodbaubles.common.events;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import zdoctor.bloodbaubles.client.render.GuiAltarInfo;
import zdoctor.bloodbaubles.common.helpers.RenderHelper;

public class RenderEvents {
  public RenderEvents() {
    MinecraftForge.EVENT_BUS.register(new RenderEvents.ForgeEvents());
    FMLCommonHandler.instance().bus().register(new RenderEvents.FMLEvents());
  }

  public static class ForgeEvents {
    @SubscribeEvent
    public void renderWorld(RenderWorldLastEvent e) {
      GuiAltarInfo.render();
    }
  }

  public static class FMLEvents {
    @SubscribeEvent
    public void renderTick(TickEvent.RenderTickEvent e) {
      RenderHelper.partialTicks = e.renderTickTime;
    }
  }
}
