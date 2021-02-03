package tech.lowspeccorgi.Quark.Elements.impl;

import org.lwjgl.input.Mouse;
import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.Style.RectStyle;
import tech.lowspeccorgi.Quark.Style.TextStyle;

import java.awt.*;

public class ButtonElement extends Element
{
    private TextStyle buttonText;
    private boolean hovered = false;
    private boolean pressed = false;
    private Color hoverColor;
    private Color pressColor;
    private Color neutralColor;
    private RectStyle rectStyle;
    private int padding;

    public ButtonElement(String id, int x, int y, int width, int height, Color hoverColor, Color pressColor, TextStyle buttonText, RectStyle rectStyle, int padding) {
        super(id, x, y, width, height);
        this.buttonText = buttonText;
        this.hoverColor = hoverColor;
        this.pressColor = pressColor;
        this.neutralColor = rectStyle.getInnerColor();
        this.rectStyle = rectStyle;
        this.padding = padding;
    }

    @Override
    public void onRender(int mouseX, int mouseY, float partialTicks)
    {
        this.pressed = (Mouse.getEventButton() == 0) && (this.hovered == true) && (Mouse.getEventButtonState() == true);
        this.hovered = (mouseX > this.x) && (mouseX < this.width) && (mouseY > this.y) && (mouseY < this.height);
        Color color = (hovered) ? (pressed) ? pressColor : hoverColor : neutralColor;
        this.rectStyle.setInnerColor(color);
        this.rectStyle.render(this.x, this.y, this.width, this.height);
        this.buttonText.render(this.x + this.padding, this.y + this.padding);
    }
}
