package zdoctor.bloodbaubles.common.baubles.pendants;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SeersPendant extends Item implements IBauble {
//	protected final ResourceLocation file;

	public SeersPendant() {
		super();
//		this.maxStackSize = 1;
//		this.setCreativeTab(CTabs.BloodRings);
//		this.setUnlocalizedName(ModMain.MODID + "_SeersPendant");
//		this.file = new ResourceLocation(ModMain.MODID + ":pendants/SeersPendant");
//		GameRegistry.register(this, this.file);
//		ZCustomItemRegistry.registerRecipe(this);
//		ZRenderRegistery.registerItem("pendants/SeersPendant", this, 0);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
//		if (!worldIn.isRemote) {
//			if (!playerIn.isSneaking()) {
//				IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
//				for(int i = 0; i < baubles.getSlots(); i++) 
//					if ((baubles.getStackInSlot(i) == null) && (baubles.isItemValidForSlot(i, itemStackIn))) {
//						baubles.setInventorySlotContents(i, itemStackIn.copy());
//						if (!playerIn.capabilities.isCreativeMode) {
//							playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, null);
//						}
//						onEquipped(itemStackIn, playerIn);
//						break;
//					}
//				}
//			} else {
//				SoulNetwork soulNetwork = NetworkHelper.getSoulNetwork(playerIn);
//				int tier = soulNetwork.getOrbTier();
//				int currentEssence = soulNetwork.getCurrentEssence();
//				int capacity = NetworkHelper.getMaximumForTier(tier);
//				playerIn.addChatComponentMessage(new TextComponentString("Current Orb Tier: " + tier));
//				playerIn.addChatComponentMessage(new TextComponentString("CurrentEssence: " + currentEssence));
//				playerIn.addChatComponentMessage(new TextComponentString("Max Capacity: " + capacity));
//			}
//		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}

	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.AMULET;
	}

	public void onWornTick(ItemStack itemstack, EntityLivingBase playerIn) {
	}

	public void onEquipped(ItemStack itemstack, EntityLivingBase playerIn) {
	}

	public void onUnequipped(ItemStack itemstack, EntityLivingBase playerIn) {
	}

	public boolean canEquip(ItemStack itemstack, EntityLivingBase playerIn) {
		return true;
	}

	public boolean canUnequip(ItemStack itemstack, EntityLivingBase playerIn) {
		return true;
	}

	public int getScanRadius() {
		return 10;
	}

	public void registerRecipe() {
//		Object[] recipe = { " x ", "xbx", " s ", Character.valueOf('x'), Items.STRING, Character.valueOf('b'),
//				OrbRegistry.getOrbStack(ModItems.orbWeak), Character.valueOf('s'), ModItems.sigilSeer };
//		GameRegistry.addShapedRecipe(new ItemStack(this, 1, 0), recipe);
	}

	public void registerVariants() {
	}
}
