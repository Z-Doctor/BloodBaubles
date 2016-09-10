package zdoctor.bloodbaubles.registry;

import java.util.ArrayList;

import baubles.api.IBauble;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zdoctor.bloodbaubles.api.IAutoRecipe;
import zdoctor.bloodbaubles.api.IAutoRegister;

/**
 * An ArrayList<IAutoReister> is created and new objects are added through
 * {@code registerBauble(IBauble bauble)}. It is recommended that you make sure
 * objects being registered are the ones you want to be registered.
 * 
 * @author Z_Doctor
 */
public final class BaubleRegistry {
	protected static ArrayList<IAutoRegister> REGISTRY = new ArrayList<>();

	public static void registerBaubles() {
		REGISTRY.forEach(bauble -> {
			bauble.registerItem();
		});
	}

	public static void registerBaubleRecipes() {
		REGISTRY.forEach(bauble -> {
			if (bauble instanceof IAutoRecipe) {
				((IAutoRecipe) bauble).registerRecipe();
			}
		});
	}

	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		REGISTRY.forEach(bauble -> {
			bauble.registerRender();
		});
	}

	public static void registerBauble(IBauble bauble) {
		if (bauble instanceof IAutoRegister)
			REGISTRY.add((IAutoRegister) bauble);
	}
}
