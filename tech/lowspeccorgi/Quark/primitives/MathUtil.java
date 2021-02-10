package tech.lowspeccorgi.Quark.primitives;

public class MathUtil
{
    public static float getAspectRatio(int width, int height)
    {
        return width / height;
    }

    public static int getScaled(int n, int height)
    {
        return height * n / 1200;
    }
}
