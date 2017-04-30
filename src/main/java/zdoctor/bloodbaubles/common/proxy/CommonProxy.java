package zdoctor.bloodbaubles.common.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.bloodbaubles.common.EventRegistry;
import zdoctor.bloodbaubles.common.ZBaubles;
import zdoctor.bloodbaubles.common.ZRecipes;
import zdoctor.bloodbaubles.creativetab.BloodBaubles;
import zdoctor.bloodbaubles.tweaks.VillageTweaks;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		ZBaubles.preInit();
		BloodBaubles.preInit();
	}

	public void init(FMLInitializationEvent e) {
		ZRecipes.init();
	}

	public void postInit(FMLPostInitializationEvent e) {
		EventRegistry.postInit();
		VillageTweaks.postInit();
	}

}