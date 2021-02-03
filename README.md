# (Quark) -> Minecraft GUI framework
An attempt to make a ui framework in Java, with the intent to be used with minecraft

This is now in a semi working state :D.

## Should I use it?
Depends. It's pretty basic but it works nicely, and has no problems, and probably will make GUI creation much easier. It also doesn't have much bloat in terms of things like elements, making it easy to make it your own. It's also pretty easy to make elements and customise them.

## Contributing
1. Follow the these code guidelines, that have been demonstrated throughout my code
2. No external libraries. The only libraries that can be used as of now, are any libraries included in vanilla minecraft 1.8.9, and the Java standard library
3. The code has to actually work :pensive:
4. Please make your code readable, and try to make things efficient
5. Please try and add Javadocs, I know I haven't done a very good job w javadocs, but please at least try

## So... How do I install it?
It's pretty simple, just download the code of this repo, and drag it into your project's folder.

## How do I add new elements?
Well, you can simply extend the Element class, and use that to create custom Elements.

## How do I customise the look?
1. I want to customise the shapes:
    1. RectStyle has quite a good amount of customisation built in, howerver you can extend RectStyle and make your own rendering function
2. I want to customise the elements:
    1. You can directly go and edit the source of the elements, if you really want to
    2. You could also just create another element with similar functionality, but with your own customisations

## X Element isn't implemented
This isn't meant to have many Elements, to make it as extensible as possible, if you really want to see an element implemented, just make a pr, or if you can't be bothered to code said element, just create an issue, for a feature request.

## Plans
- [x] Add toggle button
- [x] Add text to default button element
- [ ] Views. Scrollview, listview and gridview are must have features
- [ ] idk

## Example
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
