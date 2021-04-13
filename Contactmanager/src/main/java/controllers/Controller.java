package controllers;

import models.Model;

public abstract class Controller<M extends Model<?>> {
    protected M model;

    public void setModel(M model) {
        this.model = model;
    }
}
