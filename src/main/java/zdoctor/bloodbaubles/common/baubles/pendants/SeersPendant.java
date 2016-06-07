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
					if (baubles.getStackInSlot(i) == null && baubles.isItemValidForSlot(i, itemStackIn)) {
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
				playerIn.addChatMessage(new TextComponentString("Current Orb Tier: " + tier));
				playerIn.addChatMessage(new TextComponentString("CurrentEssence: " + currentEssence));
				playerIn.addChatMessage(new TextComponentString("Max Capacity: " + capacity));
			}
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.AMULET;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase playerIn) {
		// if (playerIn.worldObj.isRemote) {
		// SoulNetwork soulNetwork = NetworkHelper.getSoulNetwork((EntityPlayer)
		// playerIn);
		// Minecraft mc = Minecraft.getMinecraft();
		// ScaledResolution res = new ScaledResolution(mc);
		// FontRenderer fontRenderer = mc.fontRendererObj;
		// int width = res.getScaledWidth();
		// int height = res.getScaledHeight();
		// mc.entityRenderer.setupOverlayRendering();
		// String status = playerIn.getName() + ": " +
		// soulNetwork.getCurrentEssence() + " LP";
		// fontRenderer.drawString(status, 0, 300, 500, true);
		// // System.out.println(status);
		// }
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase playerIn) {

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase playerIn) {

	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase playerIn) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase playerIn) {
		return true;
	}

	public int getScanRadius() {
		return 10;
	}

	@Override
	public void registerRecipe() {
		Object[] recipe = new Object[] { " x ", "xbx", " s ", 'x', Items.STRING, 'b',
				OrbRegistry.getOrbStack(ModItems.orbWeak), 's', ModItems.sigilSeer };
		GameRegistry.addShapedRecipe(new ItemStack(this, 1, 0), recipe);
	}

	@Override
	public void registerVariants() {
		// TODO Auto-generated method stub

	}
}
