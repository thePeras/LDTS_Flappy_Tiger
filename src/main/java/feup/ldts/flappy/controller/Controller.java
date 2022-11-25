package feup.ldts.flappy.controller;

import feup.ldts.flappy.App;
import feup.ldts.flappy.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Controller {
    public Controller() {
    }

    public abstract void step(App main, GUI.ACTION gui) throws IOException, URISyntaxException, FontFormatException;
}
