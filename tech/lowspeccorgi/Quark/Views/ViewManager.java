package tech.lowspeccorgi.Quark.Views;

import tech.lowspeccorgi.Quark.Elements.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public class ViewManager
{
    private ArrayList<View> views;

    /**
     * Constructs an ViewManager given a set of views
     * @author Basilicous
     * @param views The set of Views to construct the view manager with
     */
    public ViewManager(View... views)
    {
        assert false;
        Collections.addAll(this.views, views);
    }

    /**
     * Constructs an ElementManager, with no elements
     * @author Basilicous
     */
    public ViewManager()
    {
        this.views = new ArrayList<>();
    }

    /**
     * Clears the view list
     * @author Basilicous
     */
    public void clear()
    {
        views.clear();
    }

    /**
     * Adds a element to the element list
     * @param view The element to add
     */
    public void addView(View view)
    {
        this.views.add(view);
    }

    /**
     * Adds a view to the view list
     * @param views The element to add
     */
    public void addViews(View... views)
    {
        this.views.addAll(Arrays.asList(views));
    }

    public Optional<View> getViewByID(String Id)
    {
        return this.views.stream()
                .filter(ev -> ev.getId().equals(Id))
                .findAny();
    }

    /**
     * This should be called in the "init" function
     * @author Basilicous
     */
    public void onUpdate()
    {
        views.forEach(View::onUpdate);
    }

    /**
     * This should be called in the "render" function
     * @author Basilicous
     */
    public void onRender(int mouseX, int mouseY, float partialTicks)
    {
        views.forEach(v -> v.onRender(mouseX, mouseY, partialTicks));
    }

    /**
     * This should be called in the "keyTyped()" function
     * @param typedChar The character typed
     * @param keyCode The keycode for that character
     * @author Basilicous
     */
    public void onKeyTyped(char typedChar, int keyCode)
    {
        views.forEach(v -> v.onKeyTyped(typedChar, keyCode));
    }

    /**
     * This should be called in the "mouseClicked()" function
     * @param mouseX The X position of the mouse when clicked
     * @param mouseY The Y position of the mouse when clicked
     * @param mouseButton Which mouse button was clicked
     * @author Basilicous
     */
    public void onMouseClicked(int mouseX, int mouseY, int mouseButton)
    {
        views.forEach(v -> v.onMouseClick(mouseX, mouseY, mouseButton));
    }
}
