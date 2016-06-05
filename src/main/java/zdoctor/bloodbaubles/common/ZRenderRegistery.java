package zdoctor.bloodbaubles.common;

import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ZRenderRegistery {
	private static final HashMap<String, ItemStack> registry = new HashMap<String, ItemStack>(30);
	
	public static boolean registerItem(String nameIn, Item itemIn, int meta) {
		if (registry.get(nameIn) == null) {
			registry.put(nameIn, new ItemStack(itemIn, 1, meta));
			return true;
		}
		return false;
	}

	public static void init() {
		registry.forEach((name, itemStack) -> Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
				itemStack.getItem(), itemStack.getMetadata(),
				new ModelResourceLocation(ModMain.MODID + ":" + name, "inventory")));
		registry.clear();
	}
}
