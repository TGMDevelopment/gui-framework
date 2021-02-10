package tech.lowspeccorgi.Quark.Elements.impl;

import org.lwjgl.input.Mouse;
import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.Style.RectStyle;
import tech.lowspeccorgi.Quark.Style.TextStyle;

import java.awt.*;
import java.util.ArrayList;

public class ToggleButtonElement extends Element
{
    private boolean hovered = false;
    private boolean pressed = false;
    private Color hoverColor;
    private Color pressColor;
    private Color neutralColor;
    private RectStyle rectStyle;
    private int padding;
    private ArrayList<TextStyle> states;
    private int pointer = 0;
    private ClickAction clickAction;

    public ToggleButtonElement(String id, int x, int y, int width, int height, Color hoverColor, Color pressColor, RectStyle rectStyle, int padding, ArrayList<TextStyle> states, ClickAction clickAction) {
        super(id, x, y, width, height);
        this.hoverColor = hoverColor;
        this.pressColor = pressColor;
        this.neutralColor = rectStyle.getInnerColor();
        this.rectStyle = rectStyle;
        this.padding = padding;
        this.states = states;
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
        this.states.get(this.pointer).render(this.x, this.y);
    }

    public String getState()
    {
        return this.states.get(this.pointer).getText();
    }

    @Override
    public void onMouseClick(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0 && this.hovered)
        {
            this.pointer = (this.pointer == this.states.size() - 1) ? 0 : this.pointer + 1;
            this.clickAction.onClick();
        }
        super.onMouseClick(mouseX, mouseY, mouseButton);
    }

    public ArrayList<TextStyle> getStates() {
        return states;
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    public Color getNeutralColor() {
        return neutralColor;
    }

    public Color getPressColor() {
        return pressColor;
    }

    public int getPadding() {
        return padding;
    }

    public int getPointer() {
        return pointer;
    }

    public RectStyle getRectStyle() {
        return rectStyle;
    }
}
