package zdoctor.bloodbaubles.api;

import zdoctor.bloodbaubles.token.PlayerDeathToken;

public interface ISubPlayerDeath extends ISubEvent {
	public void onEvent(PlayerDeathToken token);

	public default boolean receiveCanceled() {
		return false;
	}
}
