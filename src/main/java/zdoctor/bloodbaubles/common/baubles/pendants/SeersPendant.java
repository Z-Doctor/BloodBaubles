package zdoctor.bloodbaubles.common.baubles.pendants;

import WayofTime.bloodmagic.api.network.SoulNetwork;
import WayofTime.bloodmagic.api.registry.OrbRegistry;
import WayofTime.bloodmagic.api.util.helper.NetworkHelper;
import WayofTime.bloodmagic.registry.ModItems;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zdoctor.bloodbaubles.CTabs;
import zdoctor.bloodbaubles.ModMain;
import zdoctor.bloodbaubles.api.IConsumeBloodOrb;
import zdoctor.bloodbaubles.api.ICustomItem;
import zdoctor.bloodbaubles.common.ZCustomItemRegistry;
import zdoctor.bloodbaubles.common.ZRenderRegistery;

public class SeersPendant extends Item implements IBauble, IConsumeBloodOrb, ICustomItem {
	protected final ResourceLocation file;

	public SeersPendant() {
		super();
		this.maxStackSize = 1;
		this.setCreativeTab(CTabs.BloodRings);
		this.setUnlocalizedName(ModMain.MODID + "_SeersPendant");
		this.file = new ResourceLocation(ModMain.MODID + ":pendants/SeersPendant");
		GameRegistry.register(this, this.file);
		ZCustomItemRegistry.registerRecipe(this);
		ZRenderRegistery.registerItem("pendants/SeersPendant", this, 0);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		if (!worldIn.isRemote) {
			if (!playerIn.isSneaking()) {
				InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(playerIn);
				for (int i = 0; i < baubles.getSizeInventory(); i++) {
					if ((baubles.getStackInSlot(i) == null) && (baubles.isItemValidForSlot(i, itemStackIn))) {
						baubles.setInventorySlotContents(i, itemStackIn.copy());
						if (!playerIn.capabilities.isCreativeMode) {
							playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, null);
						}
						onEquipped(itemStackIn, playerIn);
						break;
					}
				}
			} else {
				SoulNetwork soulNetwork = NetworkHelper.getSoulNetwork(playerIn);
				int tier = soulNetwork.getOrbTier();
				int currentEssence = soulNetwork.getCurrentEssence();
				int capacity = NetworkHelper.getMaximumForTier(tier);
				playerIn.addChatComponentMessage(new TextComponentString("Current Orb Tier: " + tier));
				playerIn.addChatComponentMessage(new TextComponentString("CurrentEssence: " + currentEssence));
				playerIn.addChatComponentMessage(new TextComponentString("Max Capacity: " + capacity));
			}
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
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
		Object[] recipe = { " x ", "xbx", " s ", Character.valueOf('x'), Items.STRING, Character.valueOf('b'),
				OrbRegistry.getOrbStack(ModItems.orbWeak), Character.valueOf('s'), ModItems.sigilSeer };
		GameRegistry.addShapedRecipe(new ItemStack(this, 1, 0), recipe);
	}

	public void registerVariants() {
	}
}
