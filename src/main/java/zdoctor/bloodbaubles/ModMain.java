package zdoctor.bloodbaubles;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.bloodbaubles.init.Events;
import zdoctor.bloodbaubles.init.Rings;
import zdoctor.bloodbaubles.proxy.CommonProxy;
import zdoctor.bloodbaubles.registry.BaubleRegistry;
import zdoctor.bloodbaubles.registry.EventRegistry;

/**
 * The hope is for a highly automated, easy to maintain, easy to update, easy to
 * add-on, highly efficient mod.
 * 
 * @author Z_Doctor
 */
@Mod(modid = References.MOD_ID, name = References.NAME, version = References.VERSION)
public final class ModMain {

	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		Rings.init();
		BaubleRegistry.registerBaubles();
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		CTabs.registerTabs();
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		Events.init();
		EventRegistry.registerEvents();
		proxy.postInit(e);
	}

}
