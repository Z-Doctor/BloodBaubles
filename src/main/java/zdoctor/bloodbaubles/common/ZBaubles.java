package zdoctor.bloodbaubles.common;

import WayofTime.bloodmagic.registry.ModItems;
import zdoctor.bloodbaubles.common.item.baubles.BasicRing;
import zdoctor.bloodbaubles.common.item.baubles.BloodRing;
import zdoctor.bloodbaubles.common.item.baubles.EssenceRing;
import zdoctor.bloodbaubles.common.item.baubles.GodsGift;
import zdoctor.bloodbaubles.common.item.baubles.InsightfulTrinket;
import zdoctor.bloodbaubles.common.item.baubles.ScotopicHeadpiece;
import zdoctor.bloodbaubles.common.item.baubles.SoulRing;
import zdoctor.bloodbaubles.common.item.baubles.SprintersBelt;
import zdoctor.bloodbaubles.common.item.baubles.PryocianHeadpiece;

public class ZBaubles {
	public static BloodRing BasicRing;
	public static EssenceRing EssenceRing;
	public static GodsGift GodsGift;

	public static SoulRing SoulRing;

	public static InsightfulTrinket InsightfulTrinket;
	
	public static ScotopicHeadpiece scotopicHeadpiece;
	public static PryocianHeadpiece pryocianHeadpiece;
	
	public static SprintersBelt sprintersBelt;

	public static void preInit() {
		BasicRing = new BasicRing();
		EssenceRing = new EssenceRing();

		GodsGift = new GodsGift();
		InsightfulTrinket = new InsightfulTrinket();

		SoulRing = new SoulRing();

		scotopicHeadpiece = new ScotopicHeadpiece();
		pryocianHeadpiece = new PryocianHeadpiece();
		
		sprintersBelt = new SprintersBelt();
	}
}
