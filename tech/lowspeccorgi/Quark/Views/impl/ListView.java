package tech.lowspeccorgi.Quark.Views.impl;

import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.Views.View;

import java.util.List;

public class ListView extends View
{
    private final int offset;

    public ListView(String id, List<Element> elements, int x, int y, int offset)
    {
        super(id, elements, x, y);
        this.offset = offset;
    }

    @Override
    public void onUpdate() {
        for (int i = 0; i < this.elements.size(); i++)
        {
            elements.get(i).setX(this.x);
            elements.get(i).setY(this.y + (elements.get(i).getHeight() + this.offset) * i);
        }
    }
}
