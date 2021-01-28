package tech.lowspeccorgi.Quark.Elements;

import java.util.ArrayList;
import java.util.Collections;

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
        Collections.addAll(this.elements, elements);
    }

    /**
     * Constructs an ElementManager, with no elements
     * @author Basilicous
     */
    public ElementManager()
    {
        this.elements = new ArrayList<Element>();
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
    public void onRender()
    {
        elements.forEach(e -> e.onRender());
    }
}
