package zdoctor.bloodbaubles.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IStoreLP {
	public int getLPReserve(ItemStack itemStackIn);
	public int getMaxCapacity(ItemStack itemStackIn);
	public void addToReserve(ItemStack itemStackIn, int amount);
	public int getNeededLP(ItemStack itemStackIn);
	public boolean isFull(ItemStack itemStackIn);
	public void attemptToFillFrom(EntityPlayer playerIn, ItemStack itemStackIn);
	public int channelReserves(EntityPlayer playerIn, ItemStack itemStackIn, int neededLP);
}
