package tech.lowspeccorgi.Quark.primitives;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

/**
 * A class full of different primitive functions for drawing, to be mainly used by this library
 * @author Basilicous
 */
public class Primitives
{
    /**
     * This draws a basic rectangle, given an X position, Y position, Width, Height and a colour
     * @author Basilicous
     * @param x The X position to draw the rect at
     * @param y The Y position to draw the rect at
     * @param width The width to draw the rect as
     * @param height The height to draw the rect as
     * @param color The colour of the rect
     */
    public static void drawRect(int x, int y, int width, int height, int color)
    {
        float f3 = (float)(color >> 24 & 255) / 255.0F;
        float f = (float)(color >> 16 & 255) / 255.0F;
        float f1 = (float)(color >> 8 & 255) / 255.0F;
        float f2 = (float)(color & 255) / 255.0F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(f, f1, f2, f3);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION);
        worldrenderer.pos((double)x, (double)height, 0.0D).endVertex();
        worldrenderer.pos((double)width, (double)height, 0.0D).endVertex();
        worldrenderer.pos((double)width, (double)y, 0.0D).endVertex();
        worldrenderer.pos((double)x, (double)y, 0.0D).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
}
