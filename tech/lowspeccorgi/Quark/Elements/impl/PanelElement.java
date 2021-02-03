package tech.lowspeccorgi.Quark.Elements.impl;

import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.Style.RectStyle;

public class PanelElement extends Element {
    private RectStyle rectStyle;

    public PanelElement(String id, int x, int y, int width, int height,  RectStyle rectStyle) {
        super(id, x, y, width, height);
        this.rectStyle = rectStyle;
    }

    @Override
    public void onRender(int mouseX, int mouseY, float partialTicks) {
        this.rectStyle.render(this.x, this.y, this.width, this.height);
    }
}
