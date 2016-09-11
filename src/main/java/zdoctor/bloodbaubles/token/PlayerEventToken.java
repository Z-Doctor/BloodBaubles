package zdoctor.bloodbaubles.token;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerEventToken extends EventToken {
  public EntityPlayer player;

  public PlayerEventToken(EntityPlayer entityLiving) {
    this.player = entityLiving;
  }

  public void healPlayer() {
    this.player.heal(this.player.getMaxHealth());
  }
}
