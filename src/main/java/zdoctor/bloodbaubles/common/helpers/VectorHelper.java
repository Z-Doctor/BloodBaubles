package zdoctor.bloodbaubles.common.helpers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class VectorHelper {
  public static int getDist(int x1, int z1, int x2, int z2) {
    int l = x1 - x2;
    int j = z1 - z2;
    return (int) Math.sqrt(l * l + j * j);
  }

  public static int getTrueDist(int x1, int y1, int z1, int x2, int y2, int z2) {
    int l = x1 - x2;
    int k = y1 - y2;
    int j = z1 - z2;
    return (int) Math.sqrt(l * l + k * k + j * j);
  }

  public static boolean entityWithinDist(int posX, int posY, int posZ, Entity entity, int withinDist) {
    return getTrueDist(posX, posY, posZ, (int) entity.posX, (int) entity.posY, (int) entity.posZ) <= withinDist;
  }

  public static boolean isPlayerNearTileEntity(EntityPlayer player, TileEntity te, int scanRadius) {
    return scanRadius > getTrueDist((int) player.posX, (int) player.posY, (int) player.posZ, te.xCoord, te.yCoord, te.zCoord);
  }
}
