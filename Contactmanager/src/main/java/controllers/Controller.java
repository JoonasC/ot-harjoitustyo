package controllers;

import models.Model;

/**
 * An abstract class that represents a controller in the MVC pattern
 *
 * @param <M> The model tied to the controller
 * @author Joonas Coatanea
 */
public abstract class Controller<M extends Model<?>> {
    protected boolean mock = false;

    protected M model;

    /**
     * Sets mock mode to true. Used for tests
     */
    public void mock() {
        mock = true;
    }

    /**
     * Sets this controller's model
     *
     * @param model The model to set
     */
    public void setModel(M model) {
        this.model = model;
    }
}
