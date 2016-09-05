package zdoctor.bloodbaubles.init;

import zdoctor.bloodbaubles.events.PlayerDeathEvent;

public final class Events {
	public static void init() {
		new PlayerDeathEvent();
	}
}
