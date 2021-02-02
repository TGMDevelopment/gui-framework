package tech.lowspeccorgi.Quark.Elements.impl;

import org.lwjgl.input.Mouse;
import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.Style.RectStyle;
import tech.lowspeccorgi.Quark.primitives.Primitives;

import java.awt.*;

public class ButtonElement extends Element
{
    private String buttonText;
    private boolean hovered = false;
    private boolean pressed = false;
    private Color hoverColor;
    private Color pressColor;
    private Color neutralColor;
    private RectStyle rectStyle;

    public ButtonElement(String id, int x, int y, int width, int height, Color hoverColor, Color pressColor, Color neutralColor, String buttonText) {
        super(id, x, y, width, height);
        this.buttonText = buttonText;
        this.hoverColor = hoverColor;
        this.pressColor = pressColor;
        this.neutralColor = neutralColor;
        this.rectStyle = new RectStyle();
    }

    public ButtonElement(String id, int x, int y, int width, int height, Color hoverColor, Color pressColor, Color neutralColor, String buttonText, RectStyle rectStyle) {
        super(id, x, y, width, height);
        this.buttonText = buttonText;
        this.hoverColor = hoverColor;
        this.pressColor = pressColor;
        this.neutralColor = neutralColor;
        this.rectStyle = rectStyle;
    }

    @Override
    public void onRender(int mouseX, int mouseY, float partialTicks)
    {

        this.pressed = (Mouse.getEventButton() == 0) && (this.hovered == true) && (Mouse.getEventButtonState() == true);
        this.hovered = (mouseX > this.x) && (mouseX < this.width) && (mouseY > this.y) && (mouseY < this.height);
        Color color = (hovered) ? (pressed) ? pressColor : hoverColor : neutralColor;
        this.rectStyle.render(this.x, this.y, this.width, this.height, color);
    }
}
