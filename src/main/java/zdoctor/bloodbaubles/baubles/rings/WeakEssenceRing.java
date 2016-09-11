package zdoctor.bloodbaubles.baubles.rings;

import java.util.List;

import WayofTime.bloodmagic.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.References;
import zdoctor.bloodbaubles.api.IAutoRecipe;
import zdoctor.bloodbaubles.baubles.EssenceBloodRing;
import zdoctor.bloodbaubles.enums.EnumRingMaterial;
import zdoctor.bloodbaubles.helpers.EssenceHelper;
import zdoctor.bloodbaubles.helpers.SoulForgeRecipeHelper;

public class WeakEssenceRing extends EssenceBloodRing implements IAutoRecipe {
	private int[] cost = new int[] {30, 60, 250, 600, 1000};
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
		this.forEachVariant((meta, varName) -> {
			SoulForgeRecipeHelper reciperHelper = new SoulForgeRecipeHelper(this, meta);
			EnumRingMaterial material = EnumRingMaterial.valueOf(varName);
			reciperHelper.addCompnents(material.getMaterialStack());
			reciperHelper.addCompnents(material.getMaterialStack());
			reciperHelper.addCompnents(material.getMaterialStack());
			reciperHelper.addCompnents(material.getMaterialStack());
			reciperHelper.setDrain(this.cost[meta]);
			reciperHelper.registerRecipe();
		});
	}
}
