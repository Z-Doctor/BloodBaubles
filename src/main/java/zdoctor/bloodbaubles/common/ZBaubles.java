package zdoctor.bloodbaubles.common;

import java.util.ArrayList;

import WayofTime.bloodmagic.api.orb.IBloodOrb;
import WayofTime.bloodmagic.api.util.helper.NBTHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import zdoctor.bloodbaubles.api.IConsumeBloodOrb;
import zdoctor.bloodbaubles.common.baubles.BasicRing;
import zdoctor.bloodbaubles.common.baubles.BloodRing;
import zdoctor.bloodbaubles.common.baubles.EssenceRing;
import zdoctor.bloodbaubles.common.baubles.GodsGift;
import zdoctor.bloodbaubles.common.baubles.InsightfulTrinket;
import zdoctor.bloodbaubles.common.baubles.SoulRing;

public class ZBaubles {
	public static BloodRing BasicRing;
	public static EssenceRing EssenceRing;
	public static GodsGift GodsGift;

	public static SoulRing SoulRing;

	public static InsightfulTrinket InsightfulTrinket;

	public static void preInit() {
		BasicRing = new BasicRing();
		EssenceRing = new EssenceRing();

		GodsGift = new GodsGift();
		InsightfulTrinket = new InsightfulTrinket();

		SoulRing = new SoulRing();

	}

	public static class temp {
		public static void test(ItemCraftedEvent e) {
//			NonNullList<ItemStack> nonnulllist = CraftingManager.getInstance()
//					.getRemainingItems((InventoryCrafting) e.craftMatrix, e.player.world);
//			for (int i = 0; i < nonnulllist.size(); ++i) {
//				ItemStack itemstack = e.craftMatrix.getStackInSlot(i);
//				ItemStack itemstack1 = (ItemStack) nonnulllist.get(i);
//
//				// System.out.println("Item: " + itemstack.getDisplayName());
//				// System.out.println("Item1: " + itemstack1.getDisplayName());
//				if (itemstack1.hasTagCompound())
//					e.craftMatrix.getStackInSlot(i).setTagCompound(null);
//				else
//					NBTHelper.checkNBT(e.craftMatrix.getStackInSlot(i));
//				
//				if (itemstack.getItem() instanceof IBloodOrb) {
//					e.craftMatrix.removeStackFromSlot(i);
//				}
//				// System.out.println("Container: " +
//				// itemstack.hasTagCompound());
//				// System.out.println("Container1: " +
//				// itemstack1.hasTagCompound());
//				//
//				// System.out.println("Test: " +
//				// ItemStack.areItemStackTagsEqual(itemstack, itemstack1));
//
//				// }
//			}
//
//			// if (e.crafting.getItem() instanceof IConsumeBloodOrb) {
//			System.out.println("Start");
//			// ArrayList<ItemStack> temp = new ArrayList<>();
//			//
//			// for (int i = 0; i < e.craftMatrix.getSizeInventory(); i++) {
//			// ItemStack stack = e.craftMatrix.getStackInSlot(i).copy();
//			// if (!stack.isEmpty() && stack.getItem() instanceof IBloodOrb)
//			// {
//			// stack = ItemStack.EMPTY;
//			// } else if (!stack.isEmpty() && stack.getCount() > 1) {
//			// stack.splitStack(1);
//			// }
//			// temp.add(stack);
//			// }
//			// e.craftMatrix.clear();
//			// for(int i=0;i<temp.size();i++) {
//			// System.out.println("Item: " + temp.get(i).getDisplayName());
//			// System.out.println("Count: " + temp.get(i).getCount());
//			// e.craftMatrix.setInventorySlotContents(i, temp.get(i));
//			// }
//			// }
		}
	}
}
