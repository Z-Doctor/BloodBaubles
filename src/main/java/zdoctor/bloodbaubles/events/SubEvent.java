package zdoctor.bloodbaubles.events;

import java.util.ArrayList;

import net.minecraftforge.common.MinecraftForge;
import zdoctor.bloodbaubles.api.events.ISubEvent;
import zdoctor.bloodbaubles.registry.EventRegistry;

public abstract class SubEvent<T extends ISubEvent> {
	protected final ArrayList<T> REGISTRY = new ArrayList<>();
	private final Class<T> subType;

	public SubEvent(Class<T> subType) {
		this.subType = subType;
		EventRegistry.registerEvent(this);
	}

	public boolean isSub(ISubEvent sub) {
		return this.subType.isAssignableFrom(sub.getClass());
	}

	public void registerEvent(Object event) {
		MinecraftForge.EVENT_BUS.register(event);
	}

	public void registerSub(ISubEvent sub) {
		if (this.isSub(sub))
			this.REGISTRY.add((T) sub);
	}

}
