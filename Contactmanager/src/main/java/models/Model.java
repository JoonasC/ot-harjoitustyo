package models;

import views.View;

public abstract class Model<V extends View<?, ?>> {
    protected boolean mock = false;

    protected V view;

    public void mock() {
        mock = true;
    }

    public void setView(V view) {
        this.view = view;
    }

    public void renderView() {
        if (!mock) {
            view.render();
        }
    }
}
