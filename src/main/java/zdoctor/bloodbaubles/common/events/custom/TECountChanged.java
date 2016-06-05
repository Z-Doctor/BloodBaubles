package zdoctor.bloodbaubles.common.events.custom;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.fml.common.eventhandler.Event;

public class TECountChanged extends Event {
	protected static int lastCount = -1;
	public final List teList;
	public final int lastSize;

	public TECountChanged(List loadedTileEnityList, int lastSize) {
		this.teList = new ArrayList(loadedTileEnityList);
		this.lastSize = lastSize;
	}
}
