package zdoctor.bloodbaubles.common.baubles.rings.essence;

import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import zdoctor.bloodbaubles.ModMain;

public class RingMasters extends RingEssence {
  public RingMasters(RingMaterial material) {
    super((IBloodOrb) ModItems.masterBloodOrb, material);
    this.setUnlocalizedName(ModMain.MODID + "_" + this.getMaterialName(material) + "MastersRing");
    this.setTextureName(ModMain.MODID + ":" + this.getMaterialName(material) + "MastersRing");
  }
}
