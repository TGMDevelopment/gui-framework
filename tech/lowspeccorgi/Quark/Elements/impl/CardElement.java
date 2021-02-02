package tech.lowspeccorgi.Quark.Elements.impl;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.primitives.Primitives;

import java.awt.*;

public class CardElement extends Element
{
    private String title;
    private String description;
    private Color color;

    public CardElement(String id, int x, int y, int width, int height, Color color, String title, String description) {
        super(id, x, y, width, height);
        this.color = color;
    }

    @Override
    public void onRender(int mouseX, int mouseY, float partialTicks)
    {
        Primitives.drawRect(this.x, this.y, this.width, this.height, this.color.getRGB());
        Minecraft.getMinecraft().fontRendererObj.drawString(this.title, this.x, this.y, new Color(255, 255, 255).getRGB());
    }
}
