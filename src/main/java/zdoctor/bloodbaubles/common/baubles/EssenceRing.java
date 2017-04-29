package zdoctor.bloodbaubles.common.baubles;

import java.util.List;

import WayofTime.bloodmagic.api.orb.BloodOrb;
import WayofTime.bloodmagic.api.saving.SoulNetwork;
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

public class EssenceRing extends BloodRing implements IStoreLP {
	public static final String[] orbNameList = new String[] { "Weak", "Apprentices", "Magicians", "Masters",
			"Archmages", "Transcendents" };
	public static final BloodOrb[] orbList = new BloodOrb[] { ModItems.ORB_WEAK, ModItems.ORB_APPRENTICE,
			ModItems.ORB_MAGICIAN, ModItems.ORB_MASTER, ModItems.ORB_ARCHMAGE, ModItems.ORB_TRANSCENDENT };
	public static final String[] material = new String[] { "Iron", "Gold" };
	public static final float[] materaialMod = new float[] { .75f, .875f };

	private boolean custom = false;

	public EssenceRing() {
		super("EssenceRing", true);
		setSubCount(orbList.length * material.length);
	}

	public EssenceRing(String name, boolean hasSubTypes, BloodOrb orb) {
		super(name, hasSubTypes);
		custom = true;
	}

	@Override
	public String getNameFromDamage(int itemDamage) {
		if (this.custom)
			return super.getNameFromDamage(itemDamage);
		int materialTemp = (int) (itemDamage / (orbNameList.length));
		itemDamage = itemDamage % orbNameList.length;
		return super.getRegistryName().getResourcePath() + "_" + material[materialTemp] + "_" + orbNameList[itemDamage];
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (!world.isRemote)
			if (player.isSneaking())
				if (!this.isFull(player.getHeldItem(hand))) {
					this.attemptToFillFrom(player, player.getHeldItem(hand));
					return new ActionResult(EnumActionResult.PASS, player.getHeldItem(hand));
				}
		return super.onItemRightClick(world, player, hand);
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
		return (int) (orbList[itemStackIn.getItemDamage() % orbList.length].getCapacity()
				* (materaialMod[(int) (itemStackIn.getItemDamage() / (orbNameList.length))]));
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
//		System.out.println("Filling");
		SoulNetwork soulNetwork = NetworkHelper.getSoulNetwork(playerIn);
		int neededLP = this.getNeededLP(itemStackIn);
//		System.out.println("Cur: " + soulNetwork.getCurrentEssence() + " Needed: " + neededLP);
		if (soulNetwork.getCurrentEssence() >= neededLP) {
//			System.out.println("Enough Found");
			soulNetwork.syphon(neededLP);
			this.addToReserve(itemStackIn, neededLP);
		} else if (soulNetwork.getCurrentEssence() > 0) {
//			System.out.println("Adjusting");
			neededLP = soulNetwork.getCurrentEssence();
			soulNetwork.syphon(neededLP);
			this.addToReserve(itemStackIn, neededLP);
		}
//		System.out.println("Done");
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