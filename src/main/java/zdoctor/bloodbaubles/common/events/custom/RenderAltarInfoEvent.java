package zdoctor.bloodbaubles.common.events.custom;

import WayofTime.alchemicalWizardry.common.tileEntity.TEAltar;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;

@Cancelable
public class RenderAltarInfoEvent extends Event {
  public final TEAltar altar;
  public final EntityPlayer player;

  public RenderAltarInfoEvent(TEAltar altar, EntityPlayer player) {
    this.altar = altar;
    this.player = player;
  }
}
