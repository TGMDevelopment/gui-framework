package tech.lowspeccorgi.Quark.Style;

import tech.lowspeccorgi.Quark.primitives.Primitives;

import java.awt.*;

public class RectStyle
{
    // Some default values
    protected RectType rectType = RectType.Fill;
    protected int outlineSize = 10;
    protected CornerType cornerType = CornerType.Square;
    protected Color outlineColor = new Color(255, 255, 255);
    protected Color innerColor = new Color(0, 0, 0);

    public RectStyle(RectType rectType, CornerType cornerType, Color innerColor)
    {
        this.cornerType = cornerType;
        this.rectType = rectType;
        this.innerColor = innerColor;
    }

    public RectStyle(RectType rectType, int outlineSize, CornerType cornerType, Color innerColor, Color outlineColor)
    {
        this.cornerType = cornerType;
        this.outlineSize = outlineSize;
        this.rectType = rectType;
        this.outlineColor = outlineColor;
        this.innerColor = innerColor;
    }

    public RectStyle(RectType rectType, int outlineSize, CornerType cornerType, Color innerColor)
    {
        this.cornerType = cornerType;
        this.outlineSize = outlineSize;
        this.rectType = rectType;
        this.innerColor = innerColor;
    }

    public RectStyle(RectType rectType, CornerType cornerType)
    {
        this.cornerType = cornerType;
        this.rectType = rectType;
    }

    public RectStyle()
    {

    }

    /**
     * For advanced customization
     */
    public void render(int x, int y, int width, int height)
    {
        switch (this.rectType)
        {
            case Outline:
                switch (this.cornerType)
                {
                    case Square:
                        Primitives.drawHollowRect(x, y, width, height, this.innerColor);
                        break;
                    case Rounded:
                        Primitives.drawHollowRoundedRect(x, y, width, height, this.outlineSize, this.innerColor);
                        break;
                }
                break;
            case Fill:
                switch (this.cornerType)
                {
                    case Square:
                        Primitives.drawRect(x, y, width, height, this.innerColor.getRGB());
                        break;
                    case Rounded:
                        Primitives.drawRoundedRect(x, y, width, height, this.outlineSize, this.innerColor);
                        break;
                }
                break;
            case OutlineAndFill:
                switch (this.cornerType)
                {
                    case Square:
                        Primitives.drawRectWithOutline(x, y, width, height, this.outlineSize, this.innerColor, outlineColor);
                        break;
                    case Rounded:
                        Primitives.drawRoundedRectWithOutline(x, y, width, height, this.outlineSize, this.innerColor, outlineColor);
                        break;
                }
                break;
        }
    }

    public Color getInnerColor() {
        return innerColor;
    }

    public Color getOutlineColor() {
        return outlineColor;
    }

    public CornerType getCornerType() {
        return cornerType;
    }

    public int getOutlineSize() {
        return outlineSize;
    }

    public RectType getRectType() {
        return rectType;
    }

    public void setCornerType(CornerType cornerType) {
        this.cornerType = cornerType;
    }

    public void setInnerColor(Color innerColor) {
        this.innerColor = innerColor;
    }

    public void setOutlineColor(Color outlineColor) {
        this.outlineColor = outlineColor;
    }

    public void setOutlineSize(int outlineSize) {
        this.outlineSize = outlineSize;
    }

    public void setRectType(RectType rectType) {
        this.rectType = rectType;
    }
}
