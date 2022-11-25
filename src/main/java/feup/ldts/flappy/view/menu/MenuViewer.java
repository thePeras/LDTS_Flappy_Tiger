package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.menu.Menu;
import feup.ldts.flappy.view.Viewer;

import java.io.IOException;

public class MenuViewer extends Viewer {

    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();

        //drawElements

        gui.refresh();
    }

    @Override
    protected void drawElements(GUI gui) {
        //TODO
    }
}
