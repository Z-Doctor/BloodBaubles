package zdoctor.bloodbaubles.common.baubles.rings.mastertier;

import java.util.List;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zdoctor.bloodbaubles.ModMain;
import zdoctor.bloodbaubles.common.ZRenderRegistery;
import zdoctor.bloodbaubles.common.ZRing;
import zdoctor.bloodbaubles.common.baubles.BloodRing;

public class GodsGift extends BloodRing {
	public GodsGift() {
		super("GodsGift", true);
		setSubCount(2);
	}
	
	@Override
	public String getNameFromDamage(int itemDamage) {
		return super.getRegistryName() + (itemDamage == 0 ? "_Inactive" : "_Active");
	}
}