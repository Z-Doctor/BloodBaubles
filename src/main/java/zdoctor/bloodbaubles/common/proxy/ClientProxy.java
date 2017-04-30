package zdoctor.bloodbaubles.common.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.bloodbaubles.ModMain;
import zdoctor.bloodbaubles.client.events.RenderEvents;
import zdoctor.lazymodder.core.DevTools;

public class ClientProxy extends CommonProxy {
	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        DevTools.registerItemModels(ModMain.MODID);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        RenderEvents.postInit();
    }
}