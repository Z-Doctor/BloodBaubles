package zdoctor.bloodbaubles.api;

public interface IEventToken<T> {
	void onEvent(T eventToken);
}
