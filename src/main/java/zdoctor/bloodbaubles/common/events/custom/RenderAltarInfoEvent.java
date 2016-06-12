package zdoctor.bloodbaubles.common.events.custom;

import WayofTime.bloodmagic.tile.TileAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class RenderAltarInfoEvent extends Event {
	public final TileAltar altar;
	public final EntityPlayer player;

	public RenderAltarInfoEvent(TileAltar altar, EntityPlayer player) {
		this.altar = altar;
		this.player = player;
	}
}
