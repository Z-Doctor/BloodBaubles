package zdoctor.bloodbaubles.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import zdoctor.bloodbaubles.common.events.EventRegistry;
import zdoctor.bloodbaubles.common.recipes.RecipesAltar;
import zdoctor.bloodbaubles.common.recipes.RecipesPendants;
import zdoctor.bloodbaubles.common.recipes.RecipesRings;

public class CommonProxy {

  public void preInit(FMLPreInitializationEvent e) {
    CTabs.preInit();
    ZRings.preInit();
    ZPendants.preInit();
  }

  public void init(FMLInitializationEvent e) {
    ZRings.init();
    ZPendants.init();
    RecipesAltar.init();
    RecipesRings.init();
    RecipesPendants.init();
    EventRegistry.init();

  }

  public void postInit(FMLPostInitializationEvent e) {

  }

}
