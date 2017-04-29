package zdoctor.bloodbaubles.common.baubles;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zdoctor.bloodbaubles.CTabs;
import zdoctor.bloodbaubles.common.BloodBauble;
import zmods.lazyapi.easy.EasyItems;

public abstract class BloodRing extends BloodBauble {

	public BloodRing(String nameIn) {
		this(nameIn, false);
	}

	public BloodRing(String nameIn, boolean hasSubTypes) {
		super(nameIn, hasSubTypes);
	}
}