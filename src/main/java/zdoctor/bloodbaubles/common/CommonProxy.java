package zdoctor.bloodbaubles.common;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.bloodbaubles.CTabs;
import zdoctor.bloodbaubles.tweaks.VillageTweaks;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
//		ModBlocks.blockAltar = new TweakBlockAltar();
		ZRing.preInit();
	}

	public void init(FMLInitializationEvent e) {
//		RecipesAltar.init();
//		RecipesRings.init();
		CTabs.preInit();
		ZRing.init();
		ZPendant.init();
	}

	public void postInit(FMLPostInitializationEvent e) {
		EventRegistry.init();
		VillageTweaks.init();
	}

}
