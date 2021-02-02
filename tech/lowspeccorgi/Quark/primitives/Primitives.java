package tech.lowspeccorgi.Quark.primitives;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

import java.awt.*;

/**
 * A class full of different primitive functions for drawing, to be mainly used by this library
 * @author Basilicous
 */
public class Primitives
{
    private final Minecraft mc = Minecraft.getMinecraft();

    /**
     * This draws a basic rectangle, given an X position, Y position, Width, Height and a colour
     * @author Basilicous
     * @param left The X position to draw the rect at
     * @param top The Y position to draw the rect at
     * @param right The width to draw the rect as
     * @param bottom The height to draw the rect as
     * @param color The colour of the rect
     */
    public static void drawRect(int left, int top, int right, int bottom, int color)
    {
        if (left < right) {
            int i = left;
            left = right;
            right = i;
        }

        if (top < bottom) {
            int j = top;
            top = bottom;
            bottom = j;
        }

        float f3 = (float) (color >> 24 & 255) / 255.0F;
        float f = (float) (color >> 16 & 255) / 255.0F;
        float f1 = (float) (color >> 8 & 255) / 255.0F;
        float f2 = (float) (color & 255) / 255.0F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(f, f1, f2, f3);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION);
        worldrenderer.pos((double) left, (double) bottom, 0.0D).endVertex();
        worldrenderer.pos((double) right, (double) bottom, 0.0D).endVertex();
        worldrenderer.pos((double) right, (double) top, 0.0D).endVertex();
        worldrenderer.pos((double) left, (double) top, 0.0D).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    // This is from Danterus' (owner/developer of Sorus client) snippet, in ESS
    public static void drawRoundedRect(int left, int right, int top, int bottom, Color color, int cornerRadius)
    {
        Gui.drawRect(left, top + cornerRadius, left + cornerRadius, top + bottom - cornerRadius, color.getRGB());
        Gui.drawRect(left + cornerRadius, top, left + right - cornerRadius, top + bottom, color.getRGB());
        Gui.drawRect(left + right - cornerRadius, top + cornerRadius, left + right, top + bottom - cornerRadius, color.getRGB());

        drawArc(left + cornerRadius, top + cornerRadius, cornerRadius, 0, 90, color);
        drawArc(left + right - cornerRadius, top + cornerRadius, cornerRadius, 270, 360, color);
        drawArc(left + right - cornerRadius, top + bottom - cornerRadius, cornerRadius, 180, 270, color);
        drawArc(left + cornerRadius, top + bottom - cornerRadius, cornerRadius, 90, 180, color);
    }

    // This is also part of Danterus' snippet, thanks for making it
    public static void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GlStateManager.color((float) color.getRed() / 255, (float) color.getGreen() / 255, (float) color.getBlue() / 255, (float) color.getAlpha() / 255);

        WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();

        worldRenderer.begin(6, DefaultVertexFormats.POSITION);
        worldRenderer.pos(x, y, 0).endVertex();

        for (int i = 0; i < 360; i++) {
            double anglerad = 3.1415 * i / 180.0f;
            double X = Math.sin(anglerad) * 5;
            double Y = Math.cos(anglerad) * 5;

            worldRenderer.pos(X + x, Y + y, 0).endVertex();
        }

        Tessellator.getInstance().draw();

        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    /**
     * Credit to Decencies#3301 for both
     * Scissor functions
     */
    public static void endScissorBox() {
        GL11.glDisable(GL11.GL_SCISSOR_TEST);
        GL11.glPopMatrix();
    }


    public static void startScissorBox(final float minY, final float maxY, final float minX, final float maxX) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_SCISSOR_TEST);
        final float width = maxX - minX;
        final float height = maxY - minY;
        final Minecraft mc = Minecraft.getMinecraft();
        final float scale = (float)new ScaledResolution(mc).getScaleFactor();
        GL11.glScissor((int)(minX * scale), (int)(mc.displayHeight - (minY + height) * scale), (int)(width * scale), (int)(height * scale));
    }
}
