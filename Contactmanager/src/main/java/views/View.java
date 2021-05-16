package views;

import controllers.Controller;
import javafx.scene.Scene;
import models.Model;
import routing.Router;

import java.util.Map;

/**
 * An abstract class that represents a view in the MVC pattern
 *
 * @param <C> The controller tied to the view
 * @param <M> The model tied to the view
 * @author Joonas Coatanea
 */
public abstract class View<C extends Controller<?>, M extends Model<?>> {
    protected Router router;
    protected C controller;
    protected M model;

    public View(Router router) {
        this.router = router;
    }

    /**
     * Sets this view's controller
     *
     * @param controller The controller to set
     */
    public void setController(C controller) {
        this.controller = controller;
    }

    /**
     * Sets this view's model
     *
     * @param model The model to set
     */
    public void setModel(M model) {
        this.model = model;
    }

    /**
     * Gets the suffix of the window's title for this view
     *
     * @return The suffix of the window's title for this view
     */
    public abstract String getWindowTitleSuffix();

    /**
     * Gets the width of the window for this view
     *
     * @return The width of the window for this view
     */
    public abstract int getWindowWidth();

    /**
     * Gets the height of the window for this view
     *
     * @return The height of the window for this view
     */
    public abstract int getWindowHeight();

    /**
     * Gets the scene of this view
     *
     * @return The scene of this view
     */
    public abstract Scene getScene();

    /**
     * Informs this view that it has been navigated to by the router
     *
     * @param arguments Arguments passed to this view by the view that initiatedkj
     */
    public abstract void onNavigateTo(Map<String, Object> arguments);

    /**
     * Renders this view
     */
    public abstract void render();
}
