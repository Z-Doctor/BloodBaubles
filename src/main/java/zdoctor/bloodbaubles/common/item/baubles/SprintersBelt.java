package zdoctor.bloodbaubles.common.item.baubles;

import WayofTime.bloodmagic.api.saving.SoulNetwork;
import WayofTime.bloodmagic.api.util.helper.NetworkHelper;
import baubles.api.BaubleType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import zdoctor.bloodbaubles.common.item.BloodBauble;

public class SprintersBelt extends BloodBauble {

	public SprintersBelt() {
		super("SprintersBelt");
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		SoulNetwork network = NetworkHelper.getSoulNetwork((EntityPlayer) player);
		if (player.world.getWorldTime() % 20 == 0)
			network.syphonAndDamage((EntityPlayer) player, 2);
		if (player.getActivePotionEffect(Potion.getPotionById(1)) == null
				|| player.getActivePotionEffect(Potion.getPotionById(1)).getDuration() < 2*60)
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 3*60*20));
		super.onWornTick(itemstack, player);
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		if (player.isPotionActive(Potion.getPotionById(1)))
			player.removePotionEffect(Potion.getPotionById(1));
		super.onUnequipped(itemstack, player);
	}

}
