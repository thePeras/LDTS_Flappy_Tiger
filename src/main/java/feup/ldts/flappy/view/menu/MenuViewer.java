package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Position;
import feup.ldts.flappy.model.menu.Menu;
import feup.ldts.flappy.view.Viewer;

import java.io.IOException;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(8,11), "Menu", "#FC6A03");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {

            if (getModel().isSelected(i)) {
                gui.drawText(new Position(8, 13 + i), ">" + getModel().getEntry(i), "#FC6A03");
            } else {
                gui.drawText(new Position(9, 13 + i), getModel().getEntry(i), "#FFFFFF");
            }
        }
    }
}
