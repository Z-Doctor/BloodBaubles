package zdoctor.bloodbaubles.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;

public class ZRenderRegistery {
	private static final HashMap<String, ItemStack> registry = new HashMap(30);

	public static boolean registerItem(String nameIn, Item itemIn, int meta) {
		if (registry.get(nameIn) == null) {
			registry.put(nameIn, new ItemStack(itemIn, 1, meta));
			return true;
		}
		return false;
	}

	public static void preInit() {
		Set<String> keySet = registry.keySet();
		Iterator<String> keys = keySet.iterator();
		while (keys.hasNext()) {
			String name = (String) keys.next();
			ItemStack itemStack = (ItemStack) registry.get(name);
			ModelLoader.setCustomModelResourceLocation(itemStack.getItem(), itemStack.getMetadata(),
					new ModelResourceLocation("ZDoctorBB:" + name, "inventory"));
		}

		registry.clear();
	}
}
