package zdoctor.bloodbaubles.events;

import java.util.ArrayList;

import zdoctor.bloodbaubles.registry.EventRegistry;

public abstract class SubEvent<T> {
	protected final ArrayList<T> REGISTRY = new ArrayList<>();
	
	public SubEvent() {
		EventRegistry.registerEvent(this);
	}
	
	public abstract boolean isSub(Object obj);
	
	public abstract void registerEvent();
	
	public void registerSub (Object obj) {
		if(this.isSub(obj))
			this.REGISTRY.add((T) obj);
	}
	
}
