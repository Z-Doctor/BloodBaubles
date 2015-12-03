package zdoctor.bloodbaubles.common.events;

import net.minecraftforge.common.MinecraftForge;
import zdoctor.bloodbaubles.common.events.custom.CustomEvents;

public class EventRegistry {
  public static void init() {
    new RenderEvents();
    new RingEvents();
    new CustomEvents();
    new MiscEvents();
  }
}