package zdoctor.bloodbaubles;

import zdoctor.bloodbaubles.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModMain.MODID, name = ModMain.NAME, version = ModMain.VERSION)
public class ModMain {
  public final static String MODID = "ZDoctorBB";
  public final static String NAME = "Blood Baubles";
  public final static String VERSION = "0.2";

  @SidedProxy(clientSide = "zdoctor.bloodbaubles.client.ClientProxy", serverSide = "zdoctor.bloodbaubles.common.CommonProxy")
  public static CommonProxy proxy;

  @EventHandler
  public void preInit(FMLPreInitializationEvent e) {
    proxy.preInit(e);
  }

  @EventHandler
  public void init(FMLInitializationEvent e) {
    proxy.init(e);
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent e) {
    proxy.postInit(e);
  }

}
