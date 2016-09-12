package zdoctor.bloodbaubles.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zdoctor.bloodbaubles.api.IAutoRegister;
import zdoctor.bloodbaubles.registry.ZGameRegistry;

public class AutoBlock extends Block implements IAutoRegister {

  public AutoBlock(String nameIn, Material material) {
    super(material);
    this.setRegistryName(nameIn);
    this.setUnlocalizedName(nameIn);
    ZGameRegistry.registerAuto(this);
  }

  @Override
  public void registerToGame() {
    GameRegistry.register(this);
  }

  @Override
  public void registerRender() {
    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
        new ModelResourceLocation(this.getRegistryName().toString()));
  }
}
