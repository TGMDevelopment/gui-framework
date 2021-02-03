package tech.lowspeccorgi.Quark.Util;


import net.minecraft.client.gui.GuiScreen;
import tech.lowspeccorgi.Quark.Elements.ElementManager;

import java.io.IOException;

/**
 * Thanks Matthew <3
 */
public class EnhancedGuiScreen extends GuiScreen
{

    ElementManager em = new ElementManager();

    @Override
    public void initGui()
    {
        em.clear();
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        em.onRender(mouseX, mouseY, partialTicks);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        em.onKeyTyped(typedChar, keyCode);
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        em.onMouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}