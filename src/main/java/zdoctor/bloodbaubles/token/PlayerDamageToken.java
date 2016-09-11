package zdoctor.bloodbaubles.token;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class PlayerDamageToken extends PlayerEventToken {
  public LivingHurtEvent event;
  public DamageSource source;
  public float damage;

  public PlayerDamageToken(LivingHurtEvent e) {
    super((EntityPlayer) e.getEntityLiving());
    this.event = e;
    this.source = e.getSource();
    this.damage = e.getAmount();
  }

}
