package zdoctor.bloodbaubles.common;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.RingGold;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.RingIron;
import zdoctor.bloodbaubles.common.baubles.rings.essence.RingApprentice;
import zdoctor.bloodbaubles.common.baubles.rings.essence.RingEssence.RingMaterial;
import zdoctor.bloodbaubles.common.baubles.rings.essence.RingMagicians;
import zdoctor.bloodbaubles.common.baubles.rings.essence.RingMasters;
import zdoctor.bloodbaubles.common.baubles.rings.essence.RingWeakBlood;
import zdoctor.bloodbaubles.common.baubles.rings.mastertier.RingGodsGift;

public class ZRings {
  public static void preInit() {};
  
  public static Item RingIronRing = new RingIron();
  public static Item RingGoldRing = new RingGold();
  public static Item RingGodsGift = new RingGodsGift();
  public static Item RingWeakIronBloodRing = new RingWeakBlood(RingMaterial.IRON);
  public static Item RingWeakGoldBloodRing = new RingWeakBlood(RingMaterial.GOLD);
  public static Item RingIronApprenticeRing = new RingApprentice(RingMaterial.IRON);
  public static Item RingGoldApprenticeRing = new RingApprentice(RingMaterial.GOLD);
  public static Item RingIronMagiciansRing = new RingMagicians(RingMaterial.IRON);
  public static Item RingGoldMagiciansRing = new RingMagicians(RingMaterial.GOLD);
  public static Item RingIronMasterRing = new RingMasters(RingMaterial.IRON);
  public static Item RingGoldMasterRing = new RingMasters(RingMaterial.GOLD);;
  
  // public static Item RingZDoctorsRing = new RingZDoctors();
  
  public static void init() {
    GameRegistry.registerItem(RingIronRing, "IronRing");
    GameRegistry.registerItem(RingGoldRing, "GoldRing");
    GameRegistry.registerItem(RingGodsGift, "GodsGoft");
    GameRegistry.registerItem(RingWeakIronBloodRing, "WeakIronBloodRing");
    GameRegistry.registerItem(RingWeakGoldBloodRing, "WeakGoldBloodRing");
    GameRegistry.registerItem(RingIronApprenticeRing, "IronApprenticeRing");
    GameRegistry.registerItem(RingGoldApprenticeRing, "GoldApprenticeRing");
    GameRegistry.registerItem(RingIronMagiciansRing, "IronMagiciansRing");
    GameRegistry.registerItem(RingGoldMagiciansRing, "GoldMagiciansRing");
    GameRegistry.registerItem(RingIronMasterRing, "IronMasterRing");
    GameRegistry.registerItem(RingGoldMasterRing, "GoldMasterRing");
  };
}
