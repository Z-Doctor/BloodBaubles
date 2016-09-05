package zdoctor.bloodbaubles.api;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface IVariant {
	public void addVariant(String varName);

	public String getVariantName(int meta);

	public int getVariantMeta(String varName);
	
	public default ItemStack varientStackItem(String varName) {
		return new ItemStack((Item)this, 1, this.getVariantMeta(varName));
	}
	
	public default ItemStack varientStackBlock(String varName) {
		return new ItemStack((Block)this, 1, this.getVariantMeta(varName));
	}
}
