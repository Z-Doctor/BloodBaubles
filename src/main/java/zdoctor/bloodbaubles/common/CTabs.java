package zdoctor.bloodbaubles.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CTabs {
  public static void preInit() {};

  public static CreativeTabs BloodRings = new CreativeTabs("BloodBaubles") {

    @Override
    public Item getTabIconItem() {
      return ZRings.RingGoldMasterRing;
    }
  };
}
