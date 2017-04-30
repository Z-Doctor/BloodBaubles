package zdoctor.bloodbaubles.common;

import zdoctor.bloodbaubles.common.baubles.BasicRing;
import zdoctor.bloodbaubles.common.baubles.BloodRing;
import zdoctor.bloodbaubles.common.baubles.EssenceRing;
import zdoctor.bloodbaubles.common.baubles.GodsGift;
import zdoctor.bloodbaubles.common.baubles.InsightfulTrinket;
import zdoctor.bloodbaubles.common.baubles.SoulRing;

public class ZBaubles {
	public static BloodRing BasicRing;
	public static EssenceRing EssenceRing;
	public static GodsGift GodsGift;

	public static SoulRing SoulRing;

	public static InsightfulTrinket InsightfulTrinket;

	public static void preInit() {
		BasicRing = new BasicRing();
		EssenceRing = new EssenceRing();

		GodsGift = new GodsGift();
		InsightfulTrinket = new InsightfulTrinket();

		SoulRing = new SoulRing();

	}
}
