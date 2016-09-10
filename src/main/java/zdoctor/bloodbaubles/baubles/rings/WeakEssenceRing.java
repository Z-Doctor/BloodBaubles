package zdoctor.bloodbaubles.baubles.rings;

import java.util.List;

import WayofTime.bloodmagic.api.registry.OrbRegistry;
import WayofTime.bloodmagic.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.References;
import zdoctor.bloodbaubles.api.IAutoRecipe;
import zdoctor.bloodbaubles.baubles.EssenceBloodRing;
import zdoctor.bloodbaubles.enums.EnumRingMaterial;
import zdoctor.bloodbaubles.helpers.EssenceHelper;
import zdoctor.bloodbaubles.helpers.RecipeHelper;
import zdoctor.bloodbaubles.init.Rings;

public class WeakEssenceRing extends EssenceBloodRing implements IAutoRecipe {

	public WeakEssenceRing() {
		super(References.WEAKESSENCE, ModItems.orbWeak);
	}

	@Override
	public void addInformation(ItemStack itemStackIn, EntityPlayer playerIn, List list, boolean var4) {
		EssenceHelper eH = new EssenceHelper(itemStackIn);
		list.add(eH.getCurrentEssence() + "/" + eH.getMaxEssence());
	}

	@Override
	public void registerRecipe() {
		RecipeHelper rH = new RecipeHelper(this);
		rH.setLayer1("oxx");
		rH.setLayer2("sn");
		rH.setLayer3("rxr");
		rH.define('o', OrbRegistry.getOrbStack(ModItems.orbWeak));
		rH.define('x', Items.STICK);
		rH.define('s', Blocks.SANDSTONE);
		rH.define('n', Rings.GodsGift);
		rH.define('r', Rings.BasicRing, EnumRingMaterial.Wood.getMeta());
	}
}
