package zdoctor.bloodbaubles;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zdoctor.bloodbaubles.common.proxy.CommonProxy;

@Mod(modid = ModMain.MODID, name = ModMain.NAME, version = ModMain.VERSION , dependencies = ModMain.DEPENDENCIES)
public class ModMain {
	public static final String MODID = "bloodbaubles";
	public static final String NAME = "Blood Baubles";
	public static final String VERSION = "0.0";
	public static final String DEPENDENCIES = "required-after:lazymodder;required-after:baubles;required-after:bloodmagic";
	
	@Instance
	public static ModMain mod = new ModMain();
	
	@SidedProxy(clientSide = "zdoctor.bloodbaubles.common.proxy.ClientProxy", serverSide = "zdoctor.bloodbaubles.common.proxy.ServerProxy")
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
