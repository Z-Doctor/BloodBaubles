package zdoctor.bloodbaubles.common.baubles.rings.essence;

import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import zdoctor.bloodbaubles.ModMain;

public class RingApprentice extends RingEssence {
  public RingApprentice(RingMaterial material) {
    super((IBloodOrb) ModItems.apprenticeBloodOrb, material);
    this.setUnlocalizedName(ModMain.MODID + "_" + this.getMaterialName(material) + "ApprenticeRing");
    this.setTextureName(ModMain.MODID + ":" + this.getMaterialName(material) + "ApprenticeRing");
  }
}
