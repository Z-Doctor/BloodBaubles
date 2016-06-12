package zdoctor.bloodbaubles;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.bloodbaubles.common.CommonProxy;

@Mod(modid = "ZDoctorBB", name = "Blood Baubles", version = "1.1", acceptedMinecraftVersions = "[1.9.4]")
public class ModMain {
	public static final String MODID = "ZDoctorBB";
	public static final String NAME = "Blood Baubles";
	public static final String VERSION = "1.1";
	@net.minecraftforge.fml.common.SidedProxy(clientSide = "zdoctor.bloodbaubles.client.ClientProxy", serverSide = "zdoctor.bloodbaubles.common.CommonProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
}
