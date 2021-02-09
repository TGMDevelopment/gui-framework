package tech.lowspeccorgi.Quark.Views.impl;

import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.Views.View;

import java.util.List;

public class GridView extends View
{
    private final int xOffset;
    private final int yOffset;
    private final int gridWidth;

    public GridView(String id, List<Element> elements, int x, int y, int xOffset, int yOffset, int gridWidth)
    {
        super(id, elements, x, y);
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.gridWidth = gridWidth;
    }

    @Override
    public void onUpdate() {
        int x = 0;
        int y = 0;
        for (Element element : this.elements) {
            element.setX(this.x + (element.getWidth() + this.xOffset) * x);
            element.setY(this.y + (element.getHeight() + this.yOffset) * y);
            x += 1;
            if (x >= this.gridWidth) {
                y += 1;
                x = 0;
            }
        }
    }
}
