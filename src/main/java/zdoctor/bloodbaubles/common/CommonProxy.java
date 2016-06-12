package zdoctor.bloodbaubles.common;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.bloodbaubles.tweaks.VillageTweaks;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		ZRing.preInit();
		ZPendant.preInit();
		zdoctor.bloodbaubles.CTabs.preInit();
	}

	public void init(FMLInitializationEvent e) {
	}

	public void postInit(FMLPostInitializationEvent e) {
		EventRegistry.postInit();
		VillageTweaks.postInit();
	}
}
