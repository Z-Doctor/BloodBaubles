package zdoctor.bloodbaubles.token;

import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class PlayerDeathToken extends PlayerDamageToken {

  public PlayerDeathToken(LivingHurtEvent e) {
    super(e);
  }

  public void voidDamage() {
    this.event.setAmount(0);
  }

  public void setDamage(float f) {
    this.event.setAmount(f);
  }

}
