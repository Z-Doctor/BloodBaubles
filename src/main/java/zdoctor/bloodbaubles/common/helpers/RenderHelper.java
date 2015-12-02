package zdoctor.bloodbaubles.common.helpers;

import static org.lwjgl.opengl.GL11.glRotatef;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class RenderHelper {
  public static double partialTicks = 0;

  public static double calcRenderPos(double pos, double prevPos) {
    return (double) (prevPos + (pos - prevPos) * partialTicks);
  }

  public static void applyFloatingRotations() {
    glRotatef(-RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);
    glRotatef(RenderManager.instance.playerViewX, 1.0F, 0.0F, 0.0F);
  }

  public static void renderText(String text, int color) {
    FontRenderer fontRenderer = RenderManager.instance.getFontRenderer();
    fontRenderer.drawString(text, -fontRenderer.getStringWidth(text) / 2, -fontRenderer.FONT_HEIGHT / 2, color);
  }

  public static void applyTETranslatef(TileEntity entity, float x, float y, float z) {
    EntityPlayer player = Minecraft.getMinecraft().thePlayer;

    float diffX = (float) (entity.xCoord - RenderHelper.calcRenderPos(player.posX, player.prevPosX));
    float diffY = (float) (entity.yCoord - RenderHelper.calcRenderPos(player.posY, player.prevPosY));
    float diffZ = (float) (entity.zCoord - RenderHelper.calcRenderPos(player.posZ, player.prevPosZ));

    GL11.glTranslatef(diffX + x, diffY + y, diffZ + z);
  }

  public static void applyTETranslated(TileEntity entity, double x, double y, double z) {
    EntityPlayer player = Minecraft.getMinecraft().thePlayer;

    double diffX = entity.xCoord - RenderHelper.calcRenderPos(player.posX, player.prevPosX);
    double diffY = entity.yCoord - RenderHelper.calcRenderPos(player.posY, player.prevPosY);
    double diffZ = entity.zCoord - RenderHelper.calcRenderPos(player.posZ, player.prevPosZ);

    GL11.glTranslated(diffX + x, diffY + y, diffZ + z);
  }
}
