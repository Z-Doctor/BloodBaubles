package zdoctor.bloodbaubles.common.helpers;

import net.minecraft.util.math.BlockPos;

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

	public static boolean entityWithinDist(BlockPos pos1, BlockPos pos2, int withinDist) {
		return getTrueDist(pos1.getX(), pos1.getY(), pos1.getZ(), pos2.getX(), pos2.getY(), pos2.getZ()) <= withinDist;
	}
}
