package zdoctor.bloodbaubles.common.baubles;

import java.util.List;
import java.util.UUID;

import WayofTime.bloodmagic.api.Constants;
import WayofTime.bloodmagic.api.iface.IBindable;
import WayofTime.bloodmagic.api.saving.SoulNetwork;
import WayofTime.bloodmagic.api.util.helper.NBTHelper;
import WayofTime.bloodmagic.api.util.helper.NetworkHelper;
import WayofTime.bloodmagic.api.util.helper.PlayerHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import zdoctor.bloodbaubles.api.IConsumeBloodOrb;
import zdoctor.bloodbaubles.common.Config;

public class SoulRing extends EssenceRing implements IConsumeBloodOrb, IBindable {
	public SoulRing() {
		super("SoulRing", false);
	};

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (!world.isRemote)
			if (player.isSneaking())
				if (!this.isFull(player.getHeldItem(hand))) {
					ItemStack stack = player.getHeldItem(hand);
					UUID uuid = PlayerHelper.getUUIDFromPlayer(player);
					NBTHelper.checkNBT(stack).getTagCompound().setString(Constants.NBT.OWNER_NAME,
							PlayerHelper.getUsernameFromUUID(uuid));
					NBTHelper.checkNBT(stack).getTagCompound().setString(Constants.NBT.OWNER_UUID, uuid.toString());
					return new ActionResult(EnumActionResult.PASS, player.getHeldItem(hand));
				}
		return super.onItemRightClick(world, player, hand);
	}

	@Override
	public int channelReserves(EntityPlayer player, ItemStack itemStack, int neededLP) {
		String uuid = getOwnerUUID(itemStack);
		if (!uuid.equals("")) {
			SoulNetwork linkNetwork = NetworkHelper.getSoulNetwork(uuid);
			if (this.getLPReserve(itemStack) >= 0 && (this.getLPReserve(itemStack) >= neededLP || Config.linkPenalty)) {
				linkNetwork.syphonAndDamage(PlayerHelper.getPlayerFromUUID(uuid), neededLP);
				neededLP = 0;
			} else if (this.getLPReserve(itemStack) > 0) {
				int diff = neededLP - this.getLPReserve(itemStack);
				linkNetwork.syphonAndDamage(PlayerHelper.getPlayerFromUUID(uuid), neededLP - diff);
				neededLP -= diff;
			}
		}
		return neededLP;
	}

	@Override
	public int getLPReserve(ItemStack itemStack) {
		String uuid = NBTHelper.checkNBT(itemStack).getTagCompound().getString(Constants.NBT.OWNER_UUID);
		System.out.println(uuid.equals(""));
		if (!uuid.equals("")) {
			SoulNetwork linkNetwork = NetworkHelper.getSoulNetwork(uuid);
			return linkNetwork.getCurrentEssence();
		}
		return -1;
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer playerIn, List list, boolean var4) {
		list.add("Linked: " + (getOwnerName(itemStack).equals("") ? "No one" : getOwnerName(itemStack)));
	}

	@Override
	public String getOwnerName(ItemStack stack) {
		return NBTHelper.checkNBT(stack).getTagCompound().getString(Constants.NBT.OWNER_NAME);
	}

	@Override
	public String getOwnerUUID(ItemStack stack) {
		return NBTHelper.checkNBT(stack).getTagCompound().getString(Constants.NBT.OWNER_UUID);
	}

	@Override
	public boolean onBind(EntityPlayer player, ItemStack stack) {
		return true;
	}
}
