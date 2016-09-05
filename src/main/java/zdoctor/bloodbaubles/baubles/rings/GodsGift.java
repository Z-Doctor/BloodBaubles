package zdoctor.bloodbaubles.baubles.rings;

import net.minecraft.util.DamageSource;
import zdoctor.bloodbaubles.References;
import zdoctor.bloodbaubles.api.ISubPlayerDeath;
import zdoctor.bloodbaubles.baubles.VariantBloodRing;
import zdoctor.bloodbaubles.helpers.BaubleHelper;
import zdoctor.bloodbaubles.token.PlayerDeathToken;

public final class GodsGift extends VariantBloodRing implements ISubPlayerDeath {
	public GodsGift() {
		super(References.GODSGIFT);
		this.addVariant(References.GODSGIFT_ACTIVE);
		this.addVariant(References.GODSGIFT_INACTIVE);
	}

	@Override
	public void onEvent(PlayerDeathToken token) {
		BaubleHelper bH = new BaubleHelper(token.player);
		if (bH.isWearing(this.varientStackItem(References.GODSGIFT_ACTIVE))) {
			if (token.source != DamageSource.outOfWorld) {
				if (bH.replaceBauble(this.varientStackItem(References.GODSGIFT_ACTIVE),
						this.varientStackItem(References.GODSGIFT_INACTIVE))) {
					token.event.setCanceled(true);
					token.voidDamage();
					token.healPlayer();
				}
			}
		}
	}
}
