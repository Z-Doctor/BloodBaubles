package zdoctor.bloodbaubles.client;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.bloodbaubles.common.CommonProxy;
import zdoctor.bloodbaubles.common.ZCustomItemRegistry;
import zdoctor.bloodbaubles.common.ZRenderRegistery;
import zdoctor.bloodbaubles.common.events.RenderEvents;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		ZRenderRegistery.preInit();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		ZCustomItemRegistry.init();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		RenderEvents.postInit();
	}

}
