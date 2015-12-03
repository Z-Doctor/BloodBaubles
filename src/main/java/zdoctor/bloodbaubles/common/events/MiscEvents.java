package zdoctor.bloodbaubles.common.events;

import WayofTime.alchemicalWizardry.ModBlocks;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import zdoctor.bloodbaubles.world.data.Data;

public class MiscEvents {
  public MiscEvents() {
    MinecraftForge.EVENT_BUS.register(new MiscEvents.ForgeEvents());
    FMLCommonHandler.instance().bus().register(new MiscEvents.FMLEvents());
  }

  public static class ForgeEvents {
    @SubscribeEvent
    public void worldLoaded(WorldEvent.Load e) {
      if(e.world.isRemote)
        Data.theClientWorld = e.world;
      else
        Data.theServerWorld = e.world;
    }

    @SubscribeEvent
    public void blockPlaced(BlockEvent.PlaceEvent e) {
      if(Block.isEqualTo(e.block, ModBlocks.blockAltar) && !e.world.isRemote)
          e.world.markBlockForUpdate(e.x, e.y, e.z);
    }
  }

  public static class FMLEvents {}
}
