package feup.ldts.tanktrouble.controller;

import feup.ldts.tanktrouble.Main;
import feup.ldts.tanktrouble.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Main game, GUI.ACTION action, long time) throws IOException;
}
