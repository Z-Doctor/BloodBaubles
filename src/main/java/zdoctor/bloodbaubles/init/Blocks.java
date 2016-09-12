package zdoctor.bloodbaubles.init;

import baubles.api.BaubleType;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.base.AutoBauble;
import zdoctor.bloodbaubles.base.AutoBlock;

public class Blocks {

  public static final Block Test = new AutoBlock("Test", Material.ROCK)
      .setCreativeTab(ModCreativeTabs.BloodRings);

  public static void initBlocks() {}
}
