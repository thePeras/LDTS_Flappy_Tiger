package feup.ldts.flappy.view;

import feup.ldts.flappy.gui.GUI;

import java.io.IOException;

public class GameViewer extends Viewer{
    public GameViewer() {
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        //drawElements(gui);
        gui.refresh();
    }
}
