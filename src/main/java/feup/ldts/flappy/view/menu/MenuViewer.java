package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Colors;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.MainMenu;
import feup.ldts.flappy.view.Viewer;

public class MenuViewer extends Viewer<MainMenu> {

    public MenuViewer(MainMenu mainMenu) {
        super(mainMenu);
    }

    protected void drawElements(GUI gui) {
        gui.paintBackground(Colors.MENU_BACKGROUND.getHex());

        gui.drawMenuText(new Position(8, 11), "Menu", "#FC6A03");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (getModel().isSelected(i)) {
                gui.drawMenuText(new Position(8, 13 + i), ">" + getModel().getEntry(i), "#FC6A03");
            } else {
                gui.drawMenuText(new Position(9, 13 + i), getModel().getEntry(i), "#FFFFFF");
            }
        }

        String[] curiosity = getModel().getCuriosity().split("\n");

        gui.drawPixel(new Position(1, 20), (char) 137, Colors.ORANGE.getHex(), Colors.MENU_BACKGROUND.getHex());
        for (int i = 1; i < curiosity.length; i++) {
            gui.drawLine(new Position(1, 20 + i), curiosity[i], Colors.GREY.getHex());
        }
    }
}
