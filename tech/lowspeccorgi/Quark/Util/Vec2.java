package tech.lowspeccorgi.Quark.Util;

public class Vec2
{
    private int X;
    private int Y;

    /**
     * Constructs a Vector 2 given an x and y position
     * @author Basilicous
     * @param x The x position
     * @param y The y position
     */
    public Vec2(int x, int y)
    {
        this.X = x;
        this.Y = y;
    }

    /**
     * Constructs a Vector 2, and sets the values to zero
     * @author Basilicous
     */
    public Vec2()
    {
        this.X = 0;
        this.Y = 0;
    }

    /**
     * This gets the X position
     * @return The X position
     */
    public int getX()
    {
        return X;
    }

    /**
     * This gets the X position
     * @return The X position
     */
    public int getY()
    {
        return Y;
    }

    /**
     * This sets the X position
     * @param x The X position to set
     */
    public void setX(int x) {
        this.X = x;
    }

    /**
     * This sets the Y position
     * @param y The Y position to set
     */
    public void setY(int y) {
        this.Y = y;
    }
}
