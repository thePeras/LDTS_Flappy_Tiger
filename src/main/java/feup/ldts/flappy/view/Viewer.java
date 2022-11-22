package feup.ldts.flappy.view;

import feup.ldts.flappy.gui.GUI;

import java.io.IOException;

public abstract class Viewer {
    public abstract void draw(GUI gui) throws IOException;
}
