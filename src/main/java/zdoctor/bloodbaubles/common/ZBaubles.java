package zdoctor.bloodbaubles.common;

import net.minecraft.item.Item;
import zdoctor.bloodbaubles.common.baubles.BasicRing;
import zdoctor.bloodbaubles.common.baubles.BloodRing;
import zdoctor.bloodbaubles.common.baubles.EssenceRing;
import zdoctor.bloodbaubles.common.baubles.GodsGift;
import zdoctor.bloodbaubles.common.baubles.SeersPendant;

public class ZBaubles {
	public static BloodRing BasicRing;
	public static EssenceRing BloodRing;
	public static GodsGift GodsGift;
	
	public static Item SeersPendant;

	public static void preInit() {
		BasicRing = new BasicRing();
		BloodRing = new EssenceRing();
		
		GodsGift = new GodsGift();
		SeersPendant = new SeersPendant();
	}
}
