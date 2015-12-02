package zdoctor.bloodbaubles.common.baubles.rings.essence;

import zdoctor.bloodbaubles.ModMain;
import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;

public class RingMasters extends RingEssence {
  public RingMasters(RingMaterial material) {
    super((IBloodOrb) ModItems.masterBloodOrb, material);
    this.setUnlocalizedName(ModMain.MODID + "_" + this.getMaterialName(material) + "MastersRing");
    this.setTextureName(ModMain.MODID + ":" + this.getMaterialName(material) + "MastersRing");
  }
}
