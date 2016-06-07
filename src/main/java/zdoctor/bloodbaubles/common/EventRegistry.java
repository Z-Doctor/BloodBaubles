package zdoctor.bloodbaubles.common;

import zdoctor.bloodbaubles.common.events.CraftingEvents;
import zdoctor.bloodbaubles.common.events.RenderEvents;
import zdoctor.bloodbaubles.common.events.RingEvents;

public class EventRegistry {
	public static void postInit() {
		RingEvents.postInit();
		CraftingEvents.postInit();
	}
}