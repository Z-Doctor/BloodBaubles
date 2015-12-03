package zdoctor.bloodbaubles.common.baubles.rings.essence;

import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import zdoctor.bloodbaubles.ModMain;

public class RingMagicians extends RingEssence {
  public RingMagicians(RingMaterial material) {
    super((IBloodOrb) ModItems.magicianBloodOrb, material);
    this.setUnlocalizedName(ModMain.MODID + "_" + this.getMaterialName(material) + "MagiciansRing");
    this.setTextureName(ModMain.MODID + ":" + this.getMaterialName(material) + "MagiciansRing");
  }
}
