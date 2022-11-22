package feup.ldts.flappy.controller;

import feup.ldts.flappy.Game;
import feup.ldts.flappy.gui.GUI;

public abstract class Controller {
    public Controller() {
    }

    public abstract void step(Game main, GUI.ACTION gui);
}
