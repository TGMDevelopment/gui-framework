# gui-framework
An attempt to make a ui framework in Java, with the intent to be used with minecraft

Using raw opengl now :sunglasses:
please don't use this

it's still in heavy development

~~https://github.com/memononen/nanovg~~
~~I've chosen to use nanovg for this project, as it allows me to draw stuff easily and has lwjgl support ect~~
~~I'm not using nanovg widgets or anything~~
I just want an easy library to draw shit

# Example
```java
package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;;
import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.Elements.ElementManager;
import tech.lowspeccorgi.Quark.Elements.impl.CardElement;
import tech.lowspeccorgi.Quark.Elements.impl.PanelElement;
import tech.lowspeccorgi.Quark.Style.*;
import tech.lowspeccorgi.Quark.primitives.MathHelper;

import java.awt.*;
import java.io.IOException;

public class HudTest extends GuiScreen {
    ElementManager em = new ElementManager();

    public HudTest() {

    }

    @Override
    public void initGui() {
        em.clear();

        Element backPanel = new PanelElement("Back Panel",
                this.width / 3,
                this.height / 3,
                MathHelper.getScaled(1000, this.height),
                MathHelper.getScaled(700, this.height),
                new RectStyle(RectType.OutlineAndFill, 2, CornerType.Square, new Color(20, 20, 20)));

        Element gridPanel = new PanelElement("Grid Panel",
                backPanel.getX() + 20,
                backPanel.getY() + 20,
                backPanel.getWidth() - 20,
                backPanel.getHeight() - 20,
                new RectStyle(RectType.OutlineAndFill, 5, CornerType.Rounded, new Color(70, 70, 70), new Color(100, 100, 100)));

        Element card = new CardElement("Card",
                backPanel.getWidth() / 2,
                backPanel.getY(),
                100,
                50,
                new TextStyle(true, "Client"), new TextStyle(true, "Test"),
                new RectStyle(RectType.Outline, 5, CornerType.Square, new Color(100, 100, 100)),
                5, Anchor.Center);
        
        em.addElements(backPanel, gridPanel, card);
        em.onUpdate();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        em.onRender(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        em.onKeyTyped(typedChar, keyCode);
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        em.onMouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}
```
