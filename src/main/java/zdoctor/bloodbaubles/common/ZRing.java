package zdoctor.bloodbaubles.common;

import net.minecraft.item.Item;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.BasicGoldRing;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.BasicIronRing;
import zdoctor.bloodbaubles.common.baubles.rings.essence.WeakBloodRing;
import zdoctor.bloodbaubles.common.baubles.rings.mastertier.GodsGift;

public class ZRing {
	public static Item BasicIronRing;
	public static Item BasicGoldRing;
	public static Item GodsGift;
	public static Item WeakBloodRing;
	public static void preInit() {
		BasicIronRing = new BasicIronRing();
		BasicGoldRing = new BasicGoldRing();
		
	}
	public static void init() {
		GodsGift = new GodsGift();
		WeakBloodRing = new WeakBloodRing();
	};
//	public static Item ItemWeakIronBloodRing = new RingWeakBlood(RingMaterial.IRON);
//	public static Item ItemWeakGoldBloodRing = new RingWeakBlood(RingMaterial.GOLD);
//	public static Item ItemIronApprenticeRing = new RingApprentice(RingMaterial.IRON);
//	public static Item ItemGoldApprenticeRing = new RingApprentice(RingMaterial.GOLD);
//	public static Item ItemIronMagiciansRing = new RingMagicians(RingMaterial.IRON);
//	public static Item ItemGoldMagiciansRing = new RingMagicians(RingMaterial.GOLD);
//	public static Item ItemIronMasterRing = new RingMasters(RingMaterial.IRON);
//	public static Item ItemGoldMasterRing;
	//public static Item ItemZDoctorsRing = new RingZDoctors();
}
