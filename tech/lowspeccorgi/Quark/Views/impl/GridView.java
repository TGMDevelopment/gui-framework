package tech.lowspeccorgi.Quark.Views.impl;

import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.Views.StackingType;
import tech.lowspeccorgi.Quark.Views.View;

import java.util.List;

public class GridView extends View
{
    private int xOffset;
    private int yOffset;
    private int gridWidth;
    private StackingType stackingType;

    public GridView(String id, List<Element> elements, int x, int y, int xOffset, int yOffset, int gridWidth, StackingType stackingType)
    {
        super(id, elements, x, y);
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.gridWidth = gridWidth;
        this.stackingType = stackingType;
    }

    @Override
    public void onUpdate() {
        int x = 0;
        int y = 0;
        for (Element element : this.elements) {
            element.setX(this.x + (element.getWidth() + this.xOffset) * x);
            element.setY(this.y + (element.getHeight() + this.yOffset) * y);
            if (this.stackingType == StackingType.Vertical)
            {
                x += 1;
                if (x >= this.gridWidth) {
                    y += 1;
                    x = 0;
                }
            }
            else
            {
                y += 1;
                if (y >= this.gridWidth) {
                    x += 1;
                    y = 0;
                }
            }
        }
    }

    public int getxOffset() {
        return xOffset;
    }

    public int getyOffset() {
        return yOffset;
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
    }

    public void setStackingType(StackingType stackingType) {
        this.stackingType = stackingType;
    }

    public void setxOffset(int xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(int yOffset) {
        this.yOffset = yOffset;
    }
}
