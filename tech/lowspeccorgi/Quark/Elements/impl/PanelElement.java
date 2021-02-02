package tech.lowspeccorgi.Quark.Elements.impl;

import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.Style.RectStyle;
import tech.lowspeccorgi.Quark.primitives.Primitives;

import java.awt.*;

public class PanelElement extends Element {
    private Color color;
    private RectStyle rectStyle;

    public PanelElement(String id, int x, int y, int width, int height, Color color) {
        super(id, x, y, width, height);
        this.color = color;
        this.rectStyle = new RectStyle();
    }

    public PanelElement(String id, int x, int y, int width, int height, Color color, RectStyle rectStyle) {
        super(id, x, y, width, height);
        this.color = color;
        this.rectStyle = rectStyle;
    }

    @Override
    public void onRender(int mouseX, int mouseY, float partialTicks) {
        this.rectStyle.render(this.x, this.y, this.width, this.height, this.color);
    }
}
