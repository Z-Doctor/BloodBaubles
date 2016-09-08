package zdoctor.bloodbaubles.baubles.rings;

import java.util.List;

import WayofTime.bloodmagic.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import zdoctor.bloodbaubles.References;
import zdoctor.bloodbaubles.baubles.EssenceBloodRing;
import zdoctor.bloodbaubles.helpers.EssenceHelper;

public class WeakEssenceRing extends EssenceBloodRing {

	public WeakEssenceRing() {
		super(References.WEAKESSENCE, ModItems.orbWeak);
	}

	@Override
	public void addInformation(ItemStack itemStackIn, EntityPlayer playerIn, List list, boolean var4) {
		EssenceHelper eH = new EssenceHelper(itemStackIn);
		list.add(eH.getCurrentEssence() + "/" + eH.getMaxEssence());
	}

	// EssenceRing ring = (EssenceRing) baubles.stackList[i].getItem();
	// int diff = e.syphon - soulNetwork.getCurrentEssence();
	// soulNetwork.syphon(soulNetwork.getCurrentEssence());
	// e.syphon = ring.channelReserves(player, baubles.stackList[i], diff);
	// }
	// }
	// e.damageAmount = (float) e.syphon / 100.0f;
	// }
	// }
	// }

}
