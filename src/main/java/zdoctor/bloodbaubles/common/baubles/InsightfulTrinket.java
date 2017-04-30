package zdoctor.bloodbaubles.common.baubles;

import java.util.UUID;

import WayofTime.bloodmagic.api.Constants;
import WayofTime.bloodmagic.api.iface.IAltarReader;
import WayofTime.bloodmagic.api.saving.SoulNetwork;
import WayofTime.bloodmagic.api.util.helper.NBTHelper;
import WayofTime.bloodmagic.api.util.helper.NetworkHelper;
import WayofTime.bloodmagic.api.util.helper.PlayerHelper;
import WayofTime.bloodmagic.registry.ModItems;
import baubles.api.BaubleType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import zdoctor.bloodbaubles.api.IConsumeBloodOrb;
import zdoctor.bloodbaubles.common.item.BloodBauble;

public class InsightfulTrinket extends BloodBauble implements IAltarReader, IConsumeBloodOrb {

	public InsightfulTrinket() {
		super("InsightfulTrinket", true);
		setSubCount(2);
	}

	public int getScanRadius() {
		return 10;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (!world.isRemote) {
			if (player.isSneaking()) {
				ItemStack stack = player.getHeldItem(hand);
				UUID uuid = PlayerHelper.getUUIDFromPlayer(player);
				NBTHelper.checkNBT(stack).getTagCompound().setString(Constants.NBT.OWNER_NAME,
						PlayerHelper.getUsernameFromUUID(uuid));
				NBTHelper.checkNBT(stack).getTagCompound().setString(Constants.NBT.OWNER_UUID, uuid.toString());
				SoulNetwork soulNetwork = NetworkHelper.getSoulNetwork(player);
				switch (stack.getMetadata()) {
				case 0:
					ModItems.SIGIL_DIVINATION.onItemRightClick(world, player, hand);
					break;
				case 1:
					ModItems.SIGIL_SEER.onItemRightClick(world, player, hand);
					break;
				}

				return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
			}
		}
		return super.onItemRightClick(world, player, hand);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.TRINKET;
	}

	@Override
	public String getNameFromMeta(int meta) {
		return getRegistryName().getResourcePath() + "_" + (meta == 0 ? "Divination" : "Seers");
	}
}
