package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Colors;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.MainMenu;

public class MainMenuViewer extends MenuViewer<MainMenu> {

    public MainMenuViewer(MainMenu mainMenu) {
        super(mainMenu, new Position(8, 13));
    }

    protected void drawInsideElements(GUI gui) {
        drawTitle(gui, "Main Menu", Colors.ORANGE.getHex());

        String[] curiosity = getModel().getCuriosity().split("\n");

        gui.drawPixel(new Position(1, 20), (char) 137, Colors.ORANGE.getHex(), Colors.MENU_BACKGROUND.getHex());
        for (int i = 1; i < curiosity.length; i++) {
            gui.drawLine(new Position(1, 20 + i), curiosity[i], Colors.GREY.getHex());
        }
    }
}
