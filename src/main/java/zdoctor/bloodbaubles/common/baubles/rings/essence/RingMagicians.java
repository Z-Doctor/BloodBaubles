package zdoctor.bloodbaubles.common.baubles.rings.essence;

import zdoctor.bloodbaubles.ModMain;
import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;

public class RingMagicians extends RingEssence {
  public RingMagicians(RingMaterial material) {
    super((IBloodOrb) ModItems.magicianBloodOrb, material);
    this.setUnlocalizedName(ModMain.MODID + "_" + this.getMaterialName(material) + "MagiciansRing");
    this.setTextureName(ModMain.MODID + ":" + this.getMaterialName(material) + "MagiciansRing");
  }
}
