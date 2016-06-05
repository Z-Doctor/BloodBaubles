package zdoctor.bloodbaubles.common.baubles.rings.basetier;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zdoctor.bloodbaubles.CTabs;
import zdoctor.bloodbaubles.common.ModMain;
import zdoctor.bloodbaubles.common.ZRenderRegistery;

public class BloodRing extends Item implements IBauble {
	protected final ResourceLocation file;

	public BloodRing(String nameIn, Object[] recipeIn) {
		this(nameIn, recipeIn, false);
	}

	public BloodRing(String nameIn, Object[] recipeIn, boolean hasSubTypes) {
		this.file = new ResourceLocation(ModMain.MODID + ":rings/" + nameIn);
		this.setHasSubtypes(hasSubTypes);
		this.setMaxStackSize(1);
		this.setCreativeTab(CTabs.BloodRings);
		this.setUnlocalizedName(ModMain.MODID + "_" + nameIn);
		GameRegistry.register(this, this.file);
		if (recipeIn != null)
			GameRegistry.addShapedRecipe(new ItemStack(this, 1, 0), recipeIn);
		registerRender(nameIn);
	}

	public void registerRender(String nameIn) {
		ZRenderRegistery.registerItem("rings/" + nameIn, this, 0);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		if (!worldIn.isRemote) {
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
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public void onEquipped(ItemStack iStack, EntityLivingBase player) {
		if (!player.worldObj.isRemote) {
			player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.1F, 1.3f);
		}
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}
}