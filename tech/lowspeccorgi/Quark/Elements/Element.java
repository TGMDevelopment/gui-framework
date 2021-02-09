package tech.lowspeccorgi.Quark.Elements;

import tech.lowspeccorgi.Quark.Util.Vec2;

/**
 * This is the base class for creating an Element
 * @author Basilicous
 */
public class Element
{
    protected final String id;
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    /**
     * Creates an Element, but specifies width
     * @author Basilicous
     * @param id The name that will be used to identify the element
     * @param x The X position of the element
     * @param y The Y position of the element
     * @param width The height of the element
     * @param height The width of the element
     */
    public Element(String id, int x, int y, int width, int height)
    {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Creates an Element, but only specifies X and Y position
     * @author Basilicous
     * @param id The name that will be used to identify the element
     * @param x The X position of the element
     * @param y The Y position of the element
     */
    public Element(String id, int x, int y)
    {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = 1;
        this.height = 1;
    }

    /**
     * This gets the middle top position of the element
     * @author Basilicous
     * @return The middle top position of the element
     */
    public Vec2 getTop()
    {
        return new Vec2((this.width / 2) + this.x, this.y);
    }

    /**
     * This gets the middle bottom position of the element
     * @author Basilicous
     * @return The middle bottom position of the element
     */
    public Vec2 getBottom()
    {
        return new Vec2((this.width / 2) + this.x, this.y + this.height);
    }

    /**
     * This gets the middle left position of the element
     * @author Basilicous
     * @return The middle left position of the element
     */
    public Vec2 getLeft()
    {
        return new Vec2(this.x, (this.height / 2) + this.y);
    }

    /**
     * This gets the middle right position of the element
     * @author Basilicous
     * @return The middle right position of the element
     */
    public Vec2 getRight()
    {
        return new Vec2(this.x + this.height, (this.height / 2) + this.y);
    }

    /**
     * This gets the Identification String of the element
     * @return The ID
     */
    public String getId()
    {
        return id;
    }

    /**
     * Gets the height of the Element
     * @author Basilicous
     * @return The height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * Gets the width of the element
     * @author Basilicous
     * @return The width
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * Gets the X position of the Element
     * @author Basilicous
     * @return The X position
     */
    public int getX()
    {
        return x;
    }

    /**
     * Gets the Y position of the Element
     * @author Basilicous
     * @return The Y position
     */
    public int getY()
    {
        return y;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public float getAspectRatio()
    {
        return this.width / this.height;
    }

    /**
     * The render function of the element, elements should not be self rendered, instead rendered in the manager
     * @author Basilicous
     */
    public void onRender(int mouseX, int mouseY, float partialTicks)
    {
        //
    }

    public void onKeyTyped(char typedChar, int keyCode)
    {
        //
    }

    public void onMouseClick(int mouseX, int mouseY, int mouseButton)
    {
        //
    }

    public Element getInstance()
    {
        return this;
    }
}
