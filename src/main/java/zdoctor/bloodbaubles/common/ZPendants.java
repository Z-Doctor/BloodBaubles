package zdoctor.bloodbaubles.common;

import net.minecraft.item.Item;
import zdoctor.bloodbaubles.common.baubles.pendants.PendantSeerPendant;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZPendants {
  public static Item PendantSeerPendant = new PendantSeerPendant();

  public static void preInit() {}

  public static void init() {
    GameRegistry.registerItem(PendantSeerPendant, "SeerPendant");
  }
}
