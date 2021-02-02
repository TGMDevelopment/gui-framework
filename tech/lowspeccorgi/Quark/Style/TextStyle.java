package tech.lowspeccorgi.Quark.Style;

import net.minecraft.client.Minecraft;

public class TextStyle
{
    public boolean hasTextShadow = false;

    public TextStyle(boolean hasTextShadow)
    {
        this.hasTextShadow = hasTextShadow;
    }

    /**
     * For advanced customization
     */
    public void render(String text, int x, int y, int color)
    {
        if (hasTextShadow) Minecraft.getMinecraft().fontRendererObj.drawString(text, x, y, color);
        else Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(text, x, y, color);
    }
}
