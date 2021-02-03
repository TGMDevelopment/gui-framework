package tech.lowspeccorgi.Quark.Views;

import tech.lowspeccorgi.Quark.Elements.Element;

import java.util.ArrayList;

public class View
{
    private ArrayList<Element> elements;
    private int x;
    private int y;
    private int width;
    private String id;

    /**
     * Creates a new view
     * @param elements The list of elements you want in the view
     * @param x The X position of the view
     * @param y The Y position of the view
     * @param width The width in elements you want
     */
    public View(String id, ArrayList<Element> elements, int x, int y, int width)
    {
        this.elements = elements;
        this.x = x;
        this.y = y;
        this.width = width;
        this.id = id;
    }

    /**
     * Adds an element
     * @param e The element you want to add
     */
    public void addElement(Element e)
    {
        this.elements.add(e);
    }

    /**
     * Adds any number of elements
     * @param e The list of elements you want to add
     */
    public void addElements(Element... e)
    {
        for (int i = 0; i < e.length; i++)
        {
            elements.add(e[i]);
        }
    }

    /**
     * Clears the element list
     */
    public void clear()
    {
        this.elements.clear();
    }

    /**
     * Called in the render function
     */
    public void onRender(int mouseX, int mouseY, float partialTicks)
    {
        //
    }

    /**
     * Called in the init function
     */
    public void onUpdate()
    {
        //
    }

    /**
     * Gets the element list
     * @return Th element list
     */
    public ArrayList<Element> getElements()
    {
        return elements;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getId() {
        return id;
    }
}
