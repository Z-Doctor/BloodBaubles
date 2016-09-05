package zdoctor.bloodbaubles.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zdoctor.bloodbaubles.api.ISubPlayerDeath;
import zdoctor.bloodbaubles.token.PlayerDeathToken;

public class PlayerDeathEvent extends SubEvent<ISubPlayerDeath> {

	public PlayerDeathEvent() {
	}

	@Override
	public boolean isSub(Object obj) {
		return obj instanceof ISubPlayerDeath;
	}

	@Override
	public void registerEvent() {
		MinecraftForge.EVENT_BUS.register(new Event());
	}

	private class Event {
		@SubscribeEvent(receiveCanceled = false)
		public void deathEvent(LivingHurtEvent e) {
			if (e.getEntity() instanceof EntityPlayer && e.isCancelable()) {
				if (e.getEntityLiving().getHealth() - e.getAmount() <= 0) {
					PlayerDeathToken token = new PlayerDeathToken(e);
					REGISTRY.forEach((sub) -> {
						if (e.isCanceled() && !sub.receiveCanceled())
							return;
						else
							sub.onEvent(token);
					});
				}
			}
		}
	}

	public void init() {

	}

}
