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
    private ClickAction clickAction;

    public ButtonElement(String id, int x, int y, int width, int height, Color hoverColor, Color pressColor, TextStyle buttonText, RectStyle rectStyle, int padding, ClickAction clickAction) {
        super(id, x, y, width, height);
        this.buttonText = buttonText;
        this.hoverColor = hoverColor;
        this.pressColor = pressColor;
        this.neutralColor = rectStyle.getInnerColor();
        this.rectStyle = rectStyle;
        this.padding = padding;
        this.clickAction = clickAction;
    }

    @Override
    public void onRender(int mouseX, int mouseY, float partialTicks)
    {
        this.pressed = (Mouse.getEventButton() == 0) && (this.hovered) && (Mouse.getEventButtonState());
        this.hovered = (mouseX > this.x) && (mouseX < this.width + this.x) && (mouseY > this.y) && (mouseY < this.height + this.y);
        Color color = (hovered) ? (pressed) ? pressColor : hoverColor : neutralColor;
        this.rectStyle.setInnerColor(color);
        this.rectStyle.render(this.x, this.y, this.width, this.height);
        this.buttonText.render(this.x + this.padding, this.y + this.padding);
    }

    @Override
    public void onMouseClick(int mouseX, int mouseY, int mouseButton) {
        if (this.hovered && mouseButton == 0)
        {
            this.clickAction.onClick();
        }
    }

    public int getPadding() {
        return padding;
    }

    public RectStyle getRectStyle() {
        return rectStyle;
    }

    public Color getPressColor() {
        return pressColor;
    }

    public Color getNeutralColor() {
        return neutralColor;
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    public TextStyle getButtonText() {
        return buttonText;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    public void setPressColor(Color pressColor) {
        this.pressColor = pressColor;
    }

    public void setNeutralColor(Color neutralColor) {
        this.neutralColor = neutralColor;
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }

    public void setRectStyle(RectStyle rectStyle) {
        this.rectStyle = rectStyle;
    }
}
