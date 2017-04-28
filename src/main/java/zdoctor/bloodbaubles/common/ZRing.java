package zdoctor.bloodbaubles.common;

import zdoctor.bloodbaubles.common.baubles.BasicRing;
import zdoctor.bloodbaubles.common.baubles.BloodRing;
import zdoctor.bloodbaubles.common.baubles.EssenceRing;
import zdoctor.bloodbaubles.common.baubles.rings.mastertier.GodsGift;

public class ZRing {
	public static BloodRing BasicRing;
	public static EssenceRing BloodRing;
//	public static EssenceRing WeakBloodRing;
//	public static EssenceRing ApprenticesBloodRing;
//	public static EssenceRing MagiciansBloodRing;
//	public static EssenceRing MastersBloodRing;
//	public static EssenceRing ArchmagesBloodRing;
//	public static EssenceRing TranscendentsBloodRing;
	public static GodsGift GodsGift;

	public static void preInit() {
		BasicRing = new BasicRing();
		BloodRing = new EssenceRing();
//		WeakBloodRing = new WeakBloodRing();
//		ApprenticesBloodRing = new ApprenticesBloodRing();
//		MagiciansBloodRing = new MagiciansBloodRing();
//		MastersBloodRing = new MastersBloodRing();
//		ArchmagesBloodRing = new ArchmagesBloodRing();
//		TranscendentsBloodRing = new TranscendentsBloodRing();

		GodsGift = new GodsGift();
	}
}
