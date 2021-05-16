package models;

import views.View;

/**
 * An abstract class that represents a model in the MVC pattern
 *
 * @param <V> The view tied to the model
 * @author Joonas Coatanea
 */
public abstract class Model<V extends View<?, ?>> {
    protected boolean mock = false;

    protected V view;

    /**
     * Sets mock mode to true, which disables the ability for this model to render the view.
     * Used for tests
     */
    public void mock() {
        mock = true;
    }

    /**
     * Sets this model's view
     *
     * @param view The view to set
     */
    public void setView(V view) {
        this.view = view;
    }

    /**
     * Renders the view if mock mode is not on
     */
    public void renderView() {
        if (!mock) {
            view.render();
        }
    }
}
