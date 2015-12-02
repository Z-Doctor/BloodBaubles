package zdoctor.bloodbaubles.common.helpers;

import net.minecraft.entity.Entity;

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
}
