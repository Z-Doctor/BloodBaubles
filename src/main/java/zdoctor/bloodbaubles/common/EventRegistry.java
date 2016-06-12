package zdoctor.bloodbaubles.common;

import zdoctor.bloodbaubles.common.events.CraftingEvents;

public class EventRegistry {
	public static void postInit() {
		zdoctor.bloodbaubles.common.events.RingEvents.postInit();
		CraftingEvents.postInit();
	}
}
