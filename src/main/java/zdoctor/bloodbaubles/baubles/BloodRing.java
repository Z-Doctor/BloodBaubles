package zdoctor.bloodbaubles.baubles;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zdoctor.bloodbaubles.CTabs;
import zdoctor.bloodbaubles.api.IAutoRegister;
import zdoctor.bloodbaubles.registry.BaubleRegistry;

/**
 * An abstract class that handles basic ring functions and registration of the
 * item and textures. It is completely optional to extend this class as the main
 * functionality is through interfaces and baubles registered in the
 * {@link BaubleRegistry}, but this makes life a lot easier.
 * 
 * @author Z_Doctor
 */
public abstract class BloodRing extends Item implements IBauble, IAutoRegister {

	public BloodRing(String nameIn) {
		this.setRegistryName(nameIn);
		this.setUnlocalizedName(nameIn);
		this.setMaxStackSize(1);
		this.setCreativeTab(CTabs.BloodRings);

		BaubleRegistry.registerBauble(this);
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
	public boolean canEquip(ItemStack itemStackIn, EntityLivingBase playerIn) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemStackIn, EntityLivingBase playerIn) {
		return true;
	}

	@Override
	public void onUnequipped(ItemStack itemStackIn, EntityLivingBase playerIn) {
	}

	@Override
	public void onWornTick(ItemStack itemStackIn, EntityLivingBase playerIn) {
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemStackIn) {
		return BaubleType.RING;
	}

	@Override
	public void onEquipped(ItemStack itemStackIn, EntityLivingBase playerIn) {
		if (!playerIn.worldObj.isRemote) {
			playerIn.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.1F, 1.3f);
		}
	}

	@Override
	public void registerItem() {
		GameRegistry.register(this);
	}

	@Override
	public void registerRender() {
		ModelLoader.setCustomModelResourceLocation(this, 0,
				new ModelResourceLocation(this.getRegistryName().toString()));
	}
}