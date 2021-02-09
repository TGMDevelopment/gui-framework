package tech.lowspeccorgi.Quark.Views;

import tech.lowspeccorgi.Quark.Elements.Element;

import java.util.Arrays;
import java.util.List;

public class View
{
    protected List<Element> elements;
    protected int x;
    protected int y;
    protected String id;

    /**
     * Creates a new view
     * @param elements The list of elements you want in the view
     * @param x The X position of the view
     * @param y The Y position of the view
     */
    public View(String id, List<Element> elements, int x, int y)
    {
        this.elements = elements;
        this.x = x;
        this.y = y;
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
        elements.addAll(Arrays.asList(e));
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
        this.elements.forEach(e -> e.onRender(mouseX, mouseY, partialTicks));
    }

    /**
     * Called in the init function
     */
    public void onUpdate()
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

    /**
     * Gets the element list
     * @return Th element list
     */
    public List<Element> getElements()
    {
        return elements;
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
