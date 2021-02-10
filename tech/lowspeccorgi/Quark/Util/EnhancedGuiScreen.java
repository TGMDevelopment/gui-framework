package tech.lowspeccorgi.Quark.Util;


import net.minecraft.client.gui.GuiScreen;
import tech.lowspeccorgi.Quark.Elements.ElementManager;
import tech.lowspeccorgi.Quark.Views.ViewManager;

import java.io.IOException;

/**
 * Thanks Matthew <3
 */
public class EnhancedGuiScreen extends GuiScreen
{
    protected ElementManager em = new ElementManager();
    protected ViewManager vm = new ViewManager();

    public void preInit()
    {
        em.clear();
        vm.clear();
    }

    public void postInit()
    {
        em.onUpdate();
        vm.onUpdate();
    }

    @Override
    public void initGui()
    {
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        em.onRender(mouseX, mouseY, partialTicks);
        vm.onRender(mouseX, mouseY, partialTicks);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        em.onKeyTyped(typedChar, keyCode);
        vm.onKeyTyped(typedChar, keyCode);
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        em.onMouseClicked(mouseX, mouseY, mouseButton);
        vm.onMouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}