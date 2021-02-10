package tech.lowspeccorgi.Quark.Views;

import tech.lowspeccorgi.Quark.Elements.Element;

import java.util.Arrays;
import java.util.List;

/**
 * This is the top level element management.
 * This has layouts for Elements, and views
 * @author Basilicous
 */
public class View
{
    protected List<Element> elements;
    protected int x;
    protected int y;
    protected final String id;

    /**
     * Creates a new view
     * @param elements The list of elements you want in the view
     * @param x The X position of the view
     * @param y The Y position of the view
     * @author Basilicous
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
     * @author Basilicous
     */
    public void addElement(Element e)
    {
        this.elements.add(e);
    }

    /**
     * Adds any number of elements
     * @param e The list of elements you want to add
     * @author Basilicous
     */
    public void addElements(Element... e)
    {
        elements.addAll(Arrays.asList(e));
    }

    /**
     * Clears the element list
     * @author Basilicous
     */
    public void clear()
    {
        this.elements.clear();
    }

    /**
     * Called in the render function
     * @author Basilicous
     */
    public void onRender(int mouseX, int mouseY, float partialTicks)
    {
        this.elements.forEach(e -> e.onRender(mouseX, mouseY, partialTicks));
    }

    /**
     * Called in the init function
     * @author Basilicous
     */
    public void onUpdate()
    {

    }

    /**
     * This should be called in the "keyTyped()" function
     * @param typedChar The character typed
     * @param keyCode The keycode for that character
     * @author Basilicous
     */
    public void onKeyTyped(char typedChar, int keyCode)
    {
        this.elements.forEach(e -> e.onKeyTyped(typedChar, keyCode));
    }

    /**
     * This should be called in the "mouseClicked()" function
     * @param mouseX The X position of the mouse when clicked
     * @param mouseY The Y position of the mouse when clicked
     * @param mouseButton Which mouse button was clicked
     * @author Basilicous
     */
    public void onMouseClick(int mouseX, int mouseY, int mouseButton)
    {
        this.elements.forEach(e -> e.onMouseClick(mouseX, mouseY, mouseButton));
    }

    /**
     * Gets the element list
     * @return The element list
     * @author Basilicous
     */
    public List<Element> getElements()
    {
        return elements;
    }

    /**
     * Gets the X position of said view
     * @author Basilicous
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the Y position of said view
     * @author Basilicous
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the Y position of said view
     * @param y The Y position
     * @author Basilicous
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the X position of said view
     * @param x The X position
     * @author Basilicous
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the ID of said view
     * @return The ID
     * @author Basilicous
     */
    public String getId() {
        return id;
    }
}
