package tech.lowspeccorgi.Quark.Elements.impl;

import tech.lowspeccorgi.Quark.Elements.Element;
import tech.lowspeccorgi.Quark.Style.Anchor;
import tech.lowspeccorgi.Quark.Style.RectStyle;
import tech.lowspeccorgi.Quark.Style.TextStyle;

public class CardElement extends Element
{
    private TextStyle title;
    private TextStyle description;
    private RectStyle rectStyle;
    private int padding;
    private Anchor anchor;

    public CardElement(String id, int x, int y, int width, int height, TextStyle title, TextStyle description, RectStyle rectStyle, int padding) {
        super(id, x, y, width, height);
        this.rectStyle = rectStyle;
        this.title = title;
        this.description = description;
        this.padding = padding;
        this.anchor = Anchor.Left;
    }

    public CardElement(String id, int x, int y, int width, int height, TextStyle title, TextStyle description, RectStyle rectStyle, int padding, Anchor anchor) {
        super(id, x, y, width, height);
        this.rectStyle = rectStyle;
        this.title = title;
        this.description = description;
        this.padding = padding;
        this.anchor = anchor;
    }

    @Override
    public void onRender(int mouseX, int mouseY, float partialTicks)
    {
        this.rectStyle.render(this.x, this.y, this.width, this.height);

        switch (this.anchor)
        {
            case Center:
                this.title.render(this.x + this.padding + this.width / 2, this.y + this.padding);
                this.description.render(this.x + this.padding + this.width / 2, this.y + this.height / 2);
                break;
            case Left:
                this.title.render(this.x + this.padding, this.y + this.padding);
                this.description.render(this.x + this.padding, this.y + this.height / 2);
                break;
            default:
                this.title.render(this.x, this.y);
                this.description.render(this.x, this.y + this.height / 2);
                break;
        }
    }

    public RectStyle getRectStyle() {
        return rectStyle;
    }

    public int getPadding() {
        return padding;
    }

    public TextStyle getDescription() {
        return description;
    }

    public TextStyle getTitle() {
        return title;
    }
}
