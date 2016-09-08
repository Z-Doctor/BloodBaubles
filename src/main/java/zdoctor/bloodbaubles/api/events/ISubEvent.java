package zdoctor.bloodbaubles.api.events;

import zdoctor.bloodbaubles.token.EventToken;

public interface ISubEvent<T extends EventToken> {
	public abstract void onEvent(T token);
	
	public default boolean receiveCanceled() {
		return false;
	}
}
