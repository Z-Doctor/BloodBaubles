package zdoctor.bloodbaubles.common.events;

import java.util.EventObject;

import net.minecraftforge.client.event.RenderPlayerEvent;

public class TEAltarRenderDataEvent extends EventObject {

  public TEAltarRenderDataEvent(RenderPlayerEvent.Post event) {
    super(event);
  }

}
