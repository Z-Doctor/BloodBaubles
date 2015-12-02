package zdoctor.bloodbaubles.common.events;

import org.lwjgl.opengl.GL11;

import WayofTime.alchemicalWizardry.ModBlocks;
import WayofTime.alchemicalWizardry.api.event.ItemDrainNetworkEvent;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import WayofTime.alchemicalWizardry.api.soulNetwork.SoulNetworkHandler;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import zdoctor.bloodbaubles.common.ZRings;
import zdoctor.bloodbaubles.common.baubles.rings.essence.RingEssence;
import zdoctor.bloodbaubles.common.helpers.RenderHelper;
import zdoctor.bloodbaubles.world.data.bloodaltars.BloodAltarInfo;

public class EventRegistry {
  public static class ForgeEvents {
//    @SubscribeEvent
//    public void renderPlayer(RenderPlayerEvent.Pre e) {
//      BloodAltarInfo.renderTick();
//    }

    @SubscribeEvent
    public void renderWorld(RenderWorldLastEvent e) {
      BloodAltarInfo.renderTick();
    }


    // Adds a placed BlockBloodAltar to a list
    @SubscribeEvent
    public void blockPlaced(BlockEvent.PlaceEvent e) {
      if (Block.isEqualTo(e.block, ModBlocks.blockAltar)) {
        BloodAltarInfo.altarList.add(new BloodAltarInfo(e.world, e.x, e.y, e.z));
      }
    }

    // Removes a broken BlockBloodAltar from a list
    @SubscribeEvent
    public void blockBreaked(BlockEvent.BreakEvent e) {
      if (Block.isEqualTo(e.block, ModBlocks.blockAltar) && !e.world.isRemote) {
        BloodAltarInfo brokenAltar = new BloodAltarInfo(e.world, e.x, e.y, e.z);
        BloodAltarInfo.findAndRemoveAltar(brokenAltar);
      }
    }

    // Used by Gods Gift to Stop Fatal Damage
    @SubscribeEvent(receiveCanceled = false, priority = EventPriority.LOWEST)
    public void deathEvent(LivingHurtEvent e) {
      if (e.entity instanceof EntityPlayer && e.isCancelable()) {
        if (e.entityLiving.getHealth() - e.ammount <= 0) {
          InventoryBaubles baubles = PlayerHandler.getPlayerBaubles((EntityPlayer) e.entity);
          for (int i = 0; i < baubles.getSizeInventory(); i++) {
            if (baubles.getStackInSlot(i) != null
                && baubles.getStackInSlot(i).isItemEqual(new ItemStack(ZRings.RingGodsGift, 1, 1))) {
              baubles.stackList[i] = new ItemStack(ZRings.RingGodsGift, 1, 0);
              e.setCanceled(true);
              e.entityLiving.heal(e.entityLiving.getMaxHealth());
              break;
            }
          }
        }
      }
    }

    // Used by EssenceRings to Stop Drain Damage
    @SubscribeEvent(receiveCanceled = false)
    public void syphonEvent(ItemDrainNetworkEvent e) {
      if (e.damageAmount > 0 && !e.player.capabilities.isCreativeMode) {
        InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(e.player);
        for (int i = 0; i < baubles.getSizeInventory(); i++) {
          if (baubles.getStackInSlot(i) != null && SoulNetworkHandler.getCurrentEssence(e.ownerNetwork) < e.drainAmount
              && baubles.getStackInSlot(i).getItem() instanceof RingEssence) {
            RingEssence ring = (RingEssence) baubles.stackList[i].getItem();
            e.drainAmount = ring.drainLP(baubles.stackList[i], e.drainAmount);
          }
        }
        e.damageAmount = (float) e.drainAmount / 100.0f;
      }
    }
  }

  public static class FMLEvents {
    @SubscribeEvent
    public void playerTick(TickEvent.ClientTickEvent e) {

    }

    @SubscribeEvent
    public void renderTick(TickEvent.RenderTickEvent e) {
      RenderHelper.partialTicks = e.renderTickTime;
    }

    // Used to Consume IBloodOrbs when crafting RingEssence
    @SubscribeEvent
    public void itemCrafted(ItemCraftedEvent e) {
      if (e.crafting.getItem() instanceof RingEssence) {
        for (int i = 0; i < e.craftMatrix.getSizeInventory(); i++) {
          if (e.craftMatrix.getStackInSlot(i) != null && e.craftMatrix.getStackInSlot(i).getItem() instanceof IBloodOrb) {
            e.craftMatrix.setInventorySlotContents(i, null);
            break;
          }
        }
      }
    }
  }

  public static void init() {
    MinecraftForge.EVENT_BUS.register(new ForgeEvents());
    // MinecraftForge.TERRAIN_GEN_BUS.register(target);
    // MinecraftForge.ORE_GEN_BUS.register(target);
    FMLCommonHandler.instance().bus().register(new FMLEvents());
  }
}
