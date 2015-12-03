package zdoctor.bloodbaubles.common.baubles.rings.essence;

import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import zdoctor.bloodbaubles.ModMain;

public class RingWeakBlood extends RingEssence {
  public RingWeakBlood(RingMaterial material) {
    super((IBloodOrb) ModItems.weakBloodOrb, material);
    this.setUnlocalizedName(ModMain.MODID + "_Weak" + this.getMaterialName(material) + "BloodRing");
    this.setTextureName(ModMain.MODID + ":Weak" + this.getMaterialName(material) + "BloodRing");
  }
}
