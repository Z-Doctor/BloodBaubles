package zdoctor.bloodbaubles.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public abstract interface IStoreLP {
	public abstract int getLPReserve(ItemStack paramItemStack);

	public abstract int getMaxCapacity(ItemStack paramItemStack);

	public abstract void addToReserve(ItemStack paramItemStack, int paramInt);

	public abstract int getNeededLP(ItemStack paramItemStack);

	public abstract boolean isFull(ItemStack paramItemStack);

	public abstract void attemptToFillFrom(EntityPlayer paramEntityPlayer, ItemStack paramItemStack);

	public abstract int channelReserves(EntityPlayer paramEntityPlayer, ItemStack paramItemStack, int paramInt);
}
