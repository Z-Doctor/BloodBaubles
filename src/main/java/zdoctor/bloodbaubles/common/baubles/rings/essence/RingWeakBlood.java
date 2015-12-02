package zdoctor.bloodbaubles.common.baubles.rings.essence;

import zdoctor.bloodbaubles.ModMain;
import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;

public class RingWeakBlood extends RingEssence {
  public RingWeakBlood(RingMaterial material) {
    super((IBloodOrb) ModItems.weakBloodOrb, material);
    this.setUnlocalizedName(ModMain.MODID + "_Weak" + this.getMaterialName(material) + "BloodRing");
    this.setTextureName(ModMain.MODID + ":Weak" + this.getMaterialName(material) + "BloodRing");
  }
}
