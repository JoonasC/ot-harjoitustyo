package controllers;

import models.Model;

public abstract class Controller<M extends Model<?>> {
    protected boolean mock = false;

    protected M model;

    public void mock() {
        mock = true;
    }

    public void setModel(M model) {
        this.model = model;
    }
}
