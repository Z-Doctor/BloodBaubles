package zdoctor.bloodbaubles.common;

import zdoctor.bloodbaubles.common.baubles.rings.basetier.BasicGoldRing;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.BasicIronRing;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.BloodRing;
import zdoctor.bloodbaubles.common.baubles.rings.essence.ApprenticesBloodRing;
import zdoctor.bloodbaubles.common.baubles.rings.essence.ArchmagesBloodRing;
import zdoctor.bloodbaubles.common.baubles.rings.essence.EssenceRing;
import zdoctor.bloodbaubles.common.baubles.rings.essence.MagiciansBloodRing;
import zdoctor.bloodbaubles.common.baubles.rings.essence.MastersBloodRing;
import zdoctor.bloodbaubles.common.baubles.rings.essence.TranscendentsBloodRing;
import zdoctor.bloodbaubles.common.baubles.rings.essence.WeakBloodRing;
import zdoctor.bloodbaubles.common.baubles.rings.mastertier.GodsGift;

public class ZRing {
	public static BloodRing BasicIronRing;
	public static BloodRing BasicGoldRing;

	public static EssenceRing WeakBloodRing;
	public static EssenceRing ApprenticesBloodRing;
	public static EssenceRing MagiciansBloodRing;
	public static EssenceRing MastersBloodRing;
	public static EssenceRing ArchmagesBloodRing;
	public static EssenceRing TranscendentsBloodRing;

	public static GodsGift GodsGift;

	public static void preInit() {
		BasicIronRing = new BasicIronRing();
		BasicGoldRing = new BasicGoldRing();

		WeakBloodRing = new WeakBloodRing();
		ApprenticesBloodRing = new ApprenticesBloodRing();
		MagiciansBloodRing = new MagiciansBloodRing();
		MastersBloodRing = new MastersBloodRing();
		ArchmagesBloodRing = new ArchmagesBloodRing();
		TranscendentsBloodRing = new TranscendentsBloodRing();

		GodsGift = new GodsGift();
	}
}
