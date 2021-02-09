package tech.lowspeccorgi.Quark.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public class ElementManager
{
    private ArrayList<Element> elements;

    /**
     * Constructs an ElementManager given a set of elements
     * @author Basilicous
     * @param elements The set of Elements to construct the element manager with
     */
    public ElementManager(Element... elements)
    {
        assert false;
        Collections.addAll(this.elements, elements);
    }

    /**
     * Constructs an ElementManager, with no elements
     * @author Basilicous
     */
    public ElementManager()
    {
        this.elements = new ArrayList<>();
    }

    /**
     * Clears the element list
     * @author Basilicous
     */
    public void clear()
    {
        elements.clear();
    }

    /**
     * Adds a element to the element list
     * @param element The element to add
     */
    public void addElement(Element element)
    {
        this.elements.add(element);
    }

    /**
     * Adds a element to the element list
     * @param elements The element to add
     */
    public void addElements(Element... elements)
    {
        this.elements.addAll(Arrays.asList(elements));
    }

    public Optional<Element> getElementByID(String Id)
    {
        return this.elements.stream()
                .filter(e -> e.id.equals(Id))
                .findAny();
    }

    /**
     * This should be called in the "init" function
     * @author Basilicous
     */
    public void onUpdate()
    {

    }

    /**
     * This should be called in the "render" function
     * @author Basilicous
     */
    public void onRender(int mouseX, int mouseY, float partialTicks)
    {
        elements.forEach(e -> e.onRender(mouseX, mouseY, partialTicks));
    }

    public void onKeyTyped(char typedChar, int keyCode)
    {
        elements.forEach(e -> e.onKeyTyped(typedChar, keyCode));
    }

    public void onMouseClicked(int mouseX, int mouseY, int mouseButton)
    {
        elements.forEach(e -> e.onMouseClick(mouseX, mouseY, mouseButton));
    }
}
