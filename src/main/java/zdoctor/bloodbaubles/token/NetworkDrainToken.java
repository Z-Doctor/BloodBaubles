package zdoctor.bloodbaubles.token;

import WayofTime.bloodmagic.api.event.SoulNetworkEvent.ItemDrainNetworkEvent;
import net.minecraft.entity.player.EntityPlayer;

public class NetworkDrainToken extends EventToken {
	public ItemDrainNetworkEvent event;
	public EntityPlayer player;

	public NetworkDrainToken(ItemDrainNetworkEvent e) {
		this.event = e;
		this.player = e.player;
	}

	public boolean isCreative() {
		return this.player.isCreative();
	}

	public int getDrainAmount() {
		return this.event.syphon;
	}

	public void setDrain(int buffer) {
//		System.out.println("Drain: " + buffer);
		this.event.syphon = buffer;
	}
}
