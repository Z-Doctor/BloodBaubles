package zdoctor.bloodbaubles.common.baubles.rings.essence;

import java.util.List;

import WayofTime.bloodmagic.api.network.SoulNetwork;
import WayofTime.bloodmagic.api.util.helper.NetworkHelper;
import WayofTime.bloodmagic.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import zdoctor.bloodbaubles.api.IStoreLP;
import zdoctor.bloodbaubles.common.baubles.rings.basetier.BloodRing;

public class EssenceRing extends BloodRing implements IStoreLP {
	public EssenceRing(String nameIn, Object[] recipeIn) {
		this(nameIn, recipeIn, false);
	}

	public EssenceRing(String nameIn, Object[] recipeIn, boolean hasSubTypes) {
		super(nameIn, recipeIn, hasSubTypes);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		if (!worldIn.isRemote)
			if (playerIn.isSneaking())
				if (!this.isFull(itemStackIn)) {
					this.attemptToFillFrom(playerIn, itemStackIn);
					return new ActionResult(EnumActionResult.PASS, itemStackIn);
				}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}

	@Override
	public void addInformation(ItemStack itemStackIn, EntityPlayer playerIn, List list, boolean var4) {
		list.add(this.getLPReserve(itemStackIn) + "/" + this.getMaxCapacity(itemStackIn));
	}

	@Override
	public int getLPReserve(ItemStack itemStackIn) {
		if (itemStackIn.getTagCompound() == null || !itemStackIn.getTagCompound().hasKey("LPStored"))
			return 0;
		if (itemStackIn.getTagCompound().getInteger("LPStored") < 0)
			itemStackIn.getTagCompound().setInteger("LPStored", 0);
		return itemStackIn.getTagCompound().getInteger("LPStored");

	}

	@Override
	public int getMaxCapacity(ItemStack itemStackIn) {
		return ModItems.orbWeak.getCapacity();
	}

	@Override
	public void addToReserve(ItemStack itemStackIn, int amount) {
		System.out.println("Adding to reserve");
		if (itemStackIn.getTagCompound() == null)
			itemStackIn.setTagCompound(new NBTTagCompound());
		if (!itemStackIn.getTagCompound().hasKey("LPStored"))
			itemStackIn.getTagCompound().setInteger("LPStored", 0);
		itemStackIn.getTagCompound().setInteger("LPStored",
				itemStackIn.getTagCompound().getInteger("LPStored") + amount);
		if (itemStackIn.getTagCompound().getInteger("LPStored") > this.getMaxCapacity(itemStackIn))
			itemStackIn.getTagCompound().setInteger("LPStored", this.getMaxCapacity(itemStackIn));
	}

	@Override
	public int getNeededLP(ItemStack itemStackIn) {
		return this.getMaxCapacity(itemStackIn) - this.getLPReserve(itemStackIn);
	}

	@Override
	public boolean isFull(ItemStack itemStackIn) {
		return this.getMaxCapacity(itemStackIn) == this.getLPReserve(itemStackIn);
	}

	@Override
	public void attemptToFillFrom(EntityPlayer playerIn, ItemStack itemStackIn) {
		System.out.println("Filling");
		SoulNetwork soulNetwork = NetworkHelper.getSoulNetwork(playerIn);
		int neededLP = this.getNeededLP(itemStackIn);
		System.out.println("Cur: " + soulNetwork.getCurrentEssence() + " Needed: " + neededLP);
		if (soulNetwork.getCurrentEssence() >= neededLP) {
			System.out.println("Enough Found");
			soulNetwork.syphon(neededLP);
			this.addToReserve(itemStackIn, neededLP);
		} else if (soulNetwork.getCurrentEssence() > 0) {
			System.out.println("Adjusting");
			neededLP = soulNetwork.getCurrentEssence();
			soulNetwork.syphon(neededLP);
			this.addToReserve(itemStackIn, neededLP);
		} else
			System.out.println("Error of some kind");
		System.out.println("Done");
	}

	@Override
	public int channelReserves(EntityPlayer playerIn, ItemStack itemStackIn, int neededLP) {
		if (this.getLPReserve(itemStackIn) >= neededLP) {
			itemStackIn.getTagCompound().setInteger("LPStored", this.getLPReserve(itemStackIn) - neededLP);
			neededLP = 0;
		} else if (this.getLPReserve(itemStackIn) > 0) {
			neededLP -= this.getLPReserve(itemStackIn);
			itemStackIn.getTagCompound().setInteger("LPStored", 0);
		}
		return neededLP;
	}
}
