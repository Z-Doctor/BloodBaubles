package zdoctor.bloodbaubles.common;

import zdoctor.bloodbaubles.common.events.MiscEvents;
import zdoctor.bloodbaubles.common.events.RenderEvents;
import zdoctor.bloodbaubles.common.events.RingEvents;
import zdoctor.bloodbaubles.common.events.custom.CustomEvents;

public class EventRegistry {
  public static void init() {
    RenderEvents.init();
    RingEvents.init();
    CustomEvents.init();
    MiscEvents.init();
  }
}