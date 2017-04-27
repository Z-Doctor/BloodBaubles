package zdoctor.bloodbaubles.common.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class LocatingHelpers {
//	public static List<TileEntity> findAllTileEntitiesAround(EntityPlayer player, int scanRadius) {
//		List<TileEntity> teList = new ArrayList<TileEntity>();
//		Iterator<TileEntity> iterator = player.worldObj.loadedTileEntityList.iterator();
//		while (iterator.hasNext()) {
//			TileEntity te = iterator.next();
//			if (VectorHelper.entityWithinDist(player.getPosition(), te.getPos(), scanRadius))
//				teList.add(te);
//		}
//		return teList;
//	}
//
//	public static List<TileEntity> findTileEntitiesAround(EntityLivingBase player, int scanRadius, Class<?> find) {
//		List<TileEntity> teList = new ArrayList<TileEntity>();
//		Iterator<TileEntity> iterator = player.worldObj.loadedTileEntityList.iterator();
//		while (iterator.hasNext()) {
//			TileEntity te = iterator.next();
//			if (find.isAssignableFrom(te.getClass())) {
//				teList.add(te);
//			}
//		}
//		return teList;
//	}

}