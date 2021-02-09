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
        Gui.drawRect(left, top, right + left, bottom + top, color);
    }

    /**
     * START OF TGMDEVELOPMENT CODE
     * THIS IS PART OF THE TGMDEVELOPMENT ORGANIZATION SO GENERAL LICENSE DOES NOT HAVE TO BE FOLLOWED
     * This code was written my MatthewTGM
     * https://github.com/TGMDevelopment/TGMLib/blob/main/src/main/java/ga/matthewtgm/lib/util/RenderUtils.java
     * @param x
     * @param y
     * @param width
     * @param height
     * @param cornerRadius
     * @param color
     */
    public static void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color)
    {
        Gui.drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
        Gui.drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
        Gui.drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());

        drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
        drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
        drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
        drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
    }

    public static void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color)
    {

        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f((float) color.getRed() / 255, (float) color.getGreen() / 255, (float) color.getBlue() / 255, (float) color.getAlpha() / 255);

        WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();

        worldRenderer.begin(6, DefaultVertexFormats.POSITION);
        worldRenderer.pos(x, y, 0).endVertex();

        for (int i = (int) (startAngle / 360.0 * 100); i <= (int) (endAngle / 360.0 * 100); i++) {
            double angle = (Math.PI * 2 * i / 100) + Math.toRadians(180);
            worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0).endVertex();
        }

        Tessellator.getInstance().draw();

        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }


    public static void drawHollowArc(double x, double y, double radius, int startAngle, int endAngle, double thickness, Color color)
    {
        radius -= thickness / 2;
        x += thickness / 2;
        y += thickness / 2;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glBlendFunc(770, 771);
        GL11.glLineWidth((float) thickness);
        GL11.glColor4d(color.getRed() / 255.0, color.getGreen() / 255.0, color.getBlue() / 255.0, color.getAlpha() / 255.0);
        GL11.glBegin(GL11.GL_LINE_STRIP);
        for (double i = startAngle; i <= endAngle; i += 1) {
            GL11.glVertex2d(x + radius + Math.sin(Math.toRadians(i)) * radius, y + radius + Math.cos(Math.toRadians(i)) * radius);
        }
        GL11.glEnd();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glLineWidth(1);
    }

    public static void drawHollowRect(int x, int y, int width, int height, Color color)
    {
        drawHorizontalLine(x, x + width, y, color.getRGB());
        drawHorizontalLine(x, x + width, y + height, color.getRGB());
        drawVerticalLine(x, y + height, y, color.getRGB());
        drawVerticalLine(x + width, y + height, y, color.getRGB());
    }

    public static void drawHorizontalLine(int startX, int endX, int y, int color)
    {
        if (endX < startX) {
            int i = startX;
            startX = endX;
            endX = i;
        }

        drawRect(startX, y, endX + 1, y + 1, color);
    }

    public static void drawVerticalLine(int x, int startY, int endY, int color)
    {
        if (endY < startY) {
            int i = startY;
            startY = endY;
            endY = i;
        }

        drawRect(x, startY + 1, x + 1, endY, color);
    }

    public static void drawHollowRoundedRect(int x, int y, int width, int height, double thickness, Color color)
    {
        double radius = 4;
        drawHollowArc(x, y, radius, -180, -90, thickness, color);
        drawVerticalLine(x, y + 3, y + height - 4, color.getRGB());
        drawHorizontalLine(x + 3, x + width - 5, y, color.getRGB());
        drawHollowArc(x + width - 8, y, radius, -270, -180, thickness, color);
        drawVerticalLine(x + width - 1, y + 3, y + height - 4, color.getRGB());
        drawHorizontalLine(x + 4, x + width - 5, y + height - 1, color.getRGB());
        drawHollowArc(x + width - 8, y + height - 8, radius, 0, 90, thickness, color);
        drawHollowArc(x, y + height - 8, radius, -90, -0, thickness, color);
    }

    /**
     * END OF TGMDEVELOPMENT CODE
     */

    public static void drawRoundedRectWithOutline(int x, int y, int width, int height, int thickness,  Color innerColor, Color outlineColor)
    {
        drawRoundedRect(x, y, width, height, thickness, outlineColor);
        drawRoundedRect(x + thickness, y + thickness, width - thickness * 2, height - thickness * 2, thickness, innerColor);
    }

    public static void drawRectWithOutline(int x, int y, int width, int height, int thickness,  Color innerColor, Color outlineColor)
    {
        drawRect(x, y, x + width, y + height, outlineColor.getRGB());
        drawRect(x + thickness, y + thickness, x + width - thickness, y + height - thickness, innerColor.getRGB());
    }

    /**
     * Credit to Decencies#3301 for both
     * Scissor functions
     */
    public static void endScissorBox()
    {
        GL11.glDisable(GL11.GL_SCISSOR_TEST);
        GL11.glPopMatrix();
    }


    public static void startScissorBox(final float minY, final float maxY, final float minX, final float maxX)
    {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_SCISSOR_TEST);
        final float width = maxX - minX;
        final float height = maxY - minY;
        final Minecraft mc = Minecraft.getMinecraft();
        final float scale = (float)new ScaledResolution(mc).getScaleFactor();
        GL11.glScissor((int)(minX * scale), (int)(mc.displayHeight - (minY + height) * scale), (int)(width * scale), (int)(height * scale));
    }
}
