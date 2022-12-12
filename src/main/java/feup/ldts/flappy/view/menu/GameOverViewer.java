package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.GameOver;
import feup.ldts.flappy.view.Viewer;

public class GameOverViewer extends Viewer<GameOver> {

    public GameOverViewer(GameOver model) {
        super(model);
    }

    public void drawElements(GUI gui) {
        gui.drawText(new Position(getModel().MARGIN, 13), "G A M E   O V E R", "#FC6A03");
        gui.drawText(new Position(getModel().MARGIN, 15), "Score: " + getModel().getScore(), "#FFFFFF");
        gui.drawText(new Position(getModel().MARGIN, 17), "Enter your name:", "#FFFFFF");
        gui.drawText(new Position(getModel().MARGIN, 19), getModel().getUsername(), "#FC6A03");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (getModel().isSelected(i)) {
                gui.drawText(new Position(getModel().MARGIN-1, 21 + i), ">" + getModel().getEntry(i), "#FC6A03");
            } else {
                gui.drawText(new Position(getModel().MARGIN, 21 + i), getModel().getEntry(i), "#FFFFFF");
            }
        }
    }
}
