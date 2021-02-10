package tech.lowspeccorgi.Quark.Style;

import net.minecraft.client.Minecraft;

import java.awt.*;

public class TextStyle
{
    private boolean hasTextShadow;
    private String text;
    private Color color;

    public TextStyle(boolean hasTextShadow, String text, Color color)
    {
        this.hasTextShadow = hasTextShadow;
        this.text = text;
        this.color = color;
    }

    public TextStyle(boolean hasTextShadow, String text)
    {
        this.hasTextShadow = hasTextShadow;
        this.text = text;
        this.color = new Color(255, 255, 255);
    }

    /**
     * For advanced customization
     */
    public void render(int x, int y)
    {
        if (hasTextShadow) Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.text, x, y, this.color.getRGB());
        else Minecraft.getMinecraft().fontRendererObj.drawString(this.text, x, y, this.color.getRGB());
    }

    public Color getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    public boolean getTextShadow()
    {
        return this.hasTextShadow;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setHasTextShadow(boolean hasTextShadow) {
        this.hasTextShadow = hasTextShadow;
    }

    public void setText(String text) {
        this.text = text;
    }
}
