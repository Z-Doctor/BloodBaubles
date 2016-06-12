package zdoctor.bloodbaubles.common.events;

import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import zdoctor.bloodbaubles.client.render.GuiAltarInfo;
import zdoctor.bloodbaubles.common.helpers.RenderHelper;

public class RenderEvents {
	public static void postInit() {
		MinecraftForge.EVENT_BUS.register(new Events());
	}

	private static class Events {
		@SubscribeEvent
		public void renderWorld(RenderWorldLastEvent e) {
			GuiAltarInfo.render();
		}

		@SubscribeEvent
		public void renderTick(TickEvent.RenderTickEvent e) {
			RenderHelper.partialTicks = e.renderTickTime;
		}
	}
}
