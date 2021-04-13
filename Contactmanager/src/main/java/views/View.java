package views;

import controllers.Controller;
import javafx.scene.Scene;
import models.Model;
import routing.Router;

public abstract class View<C extends Controller<?>, M extends Model<?>> {
    protected Router router;
    protected C controller;
    protected M model;

    public View(Router router) {
        this.router = router;
    }

    public void setController(C controller) {
        this.controller = controller;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public abstract String getWindowTitleSuffix();

    public abstract int getWindowWidth();

    public abstract int getWindowHeight();

    public abstract Scene getScene();

    public abstract void render();
}
