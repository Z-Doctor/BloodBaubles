package zdoctor.bloodbaubles.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.bloodbaubles.registry.BaubleRegistry;

public class ClientProxy implements CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		BaubleRegistry.registerRenders();
	}

	@Override
	public void init(FMLInitializationEvent e) {
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
	}

}
