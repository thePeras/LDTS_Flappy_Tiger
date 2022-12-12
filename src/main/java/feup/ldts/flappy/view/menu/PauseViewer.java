package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Colors;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.Pause;
import feup.ldts.flappy.view.Viewer;

import java.io.IOException;

public class PauseViewer extends Viewer<Pause> {

    public PauseViewer(Pause model) {
        super(model);
    }

    protected void drawElements(GUI gui) {
        gui.paintBackground(Colors.MENU_BACKGROUND.getHex());

        gui.drawMenuText(new Position(8, 11), "Pause", "#FC6A03");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (getModel().isSelected(i)) {
                gui.drawMenuText(new Position(8, 13 + i), ">" + getModel().getEntry(i), "#FC6A03");
            } else {
                gui.drawMenuText(new Position(9, 13 + i), getModel().getEntry(i), "#FFFFFF");
            }
        }
    }
}
