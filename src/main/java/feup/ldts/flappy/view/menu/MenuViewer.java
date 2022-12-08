package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Position;
import feup.ldts.flappy.model.menu.MainMenu;
import feup.ldts.flappy.view.Viewer;

import java.io.IOException;

public class MenuViewer extends Viewer<MainMenu> {

    public MenuViewer(MainMenu mainMenu) {
        super(mainMenu);
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
        String[] curiosity = getModel().getCuriosity().split("\n");

        gui.drawText(new Position(1, 20), "L", "#FC6A03");

        for (int i = 0; i < curiosity.length; i++) {
            if(i>1) {
                gui.drawText(new Position(1, 20 + i), "O", "#FFFFFF");
            }
            gui.drawText(new Position(3, 20 + i), curiosity[i], "#FC6A03");
        }
    }
}
