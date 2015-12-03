package zdoctor.bloodbaubles.common.helpers;

import java.util.ArrayList;
import java.util.List;

import WayofTime.alchemicalWizardry.api.tile.IBloodAltar;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BMHelpers {
  public static IBloodAltar findNeareastAltar(World world, int x, int y, int z, int withinDist) {
    TileEntity tileEntity;
    for (int i = -withinDist; i <= withinDist; i++) {
      for (int j = -withinDist; j <= withinDist; j++) {
        for (int k = -withinDist; k <= withinDist; k++) {
          tileEntity = world.getTileEntity(i + x, k + y, j + z);
          if (tileEntity instanceof IBloodAltar) {
            return (IBloodAltar) tileEntity;
          }
        }
      }
    }
    return null;
  }
  
  public static List<IBloodAltar> findNeareastAltars(World world, int x, int y, int z, int withinDist) {
    List<IBloodAltar> altarList = new ArrayList<IBloodAltar>();
    TileEntity tileEntity;
    for (int i = -withinDist; i <= withinDist; i++) {
      for (int j = -withinDist; j <= withinDist; j++) {
        for (int k = -withinDist; k <= withinDist; k++) {
          tileEntity = world.getTileEntity(i + x, k + y, j + z);
          if (tileEntity instanceof IBloodAltar) {
            altarList.add((IBloodAltar) tileEntity);
          }
        }
      }
    }
    if(altarList.size() == 0)
      return null;
    return altarList;
  }
}
