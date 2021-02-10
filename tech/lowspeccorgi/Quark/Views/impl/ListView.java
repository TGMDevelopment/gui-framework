package tech.lowspeccorgi.Quark.Views.impl;

import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.Views.StackingType;
import tech.lowspeccorgi.Quark.Views.View;

import java.util.List;

public class ListView extends View
{
    private int offset;
    private StackingType stackingType;

    public ListView(String id, List<Element> elements, int x, int y, int offset, StackingType stackingType)
    {
        super(id, elements, x, y);
        this.offset = offset;
        this.stackingType = stackingType;
    }

    @Override
    public void onUpdate() {
        for (int i = 0; i < this.elements.size(); i++)
        {
            elements.get(i).setX((this.stackingType == StackingType.Horizontal) ? this.x + (elements.get(i).getWidth() + this.offset) * i : this.x);
            elements.get(i).setY((this.stackingType == StackingType.Horizontal) ? this.y : this.y + (elements.get(i).getHeight() + this.offset) * i);
        }
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }

    public void setStackingType(StackingType stackingType) {
        this.stackingType = stackingType;
    }
}
