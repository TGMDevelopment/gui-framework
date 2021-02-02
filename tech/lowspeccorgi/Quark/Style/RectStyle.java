package tech.lowspeccorgi.Quark.Style;

import tech.lowspeccorgi.Quark.primitives.Primitives;

import java.awt.*;

public class RectStyle
{
    public RectType rectType = RectType.Fill;
    public int outlineSize = 10;
    public CornerType cornerType = CornerType.Square;

    public RectStyle(RectType rectType, int outlineSize, CornerType cornerType)
    {
        this.cornerType = cornerType;
        this.outlineSize = outlineSize;
        this.rectType = rectType;
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
    public void render(int x, int y, int width, int height, Color color)
    {
        if (this.cornerType == CornerType.Square) Primitives.drawRect(x, y, width, height, color.getRGB());
        else Primitives.drawRoundedRect(x, y, width, height, color, this.outlineSize);
    }
}
