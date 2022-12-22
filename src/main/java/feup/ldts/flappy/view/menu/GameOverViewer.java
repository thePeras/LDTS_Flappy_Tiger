package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.GameOver;

public class GameOverViewer extends MenuViewer<GameOver> {

    public GameOverViewer(GameOver model) {
        super(model, new Position(model.MARGIN - 1, 21));
    }

    public void drawInsideElements(GUI gui) {
        drawText(gui, new Position(getModel().MARGIN, 13), "G A M E   O V E R", "#FC6A03");
        drawText(gui, new Position(getModel().MARGIN, 15), "Score: " + getModel().getScore(), "#FFFFFF");
        drawText(gui, new Position(getModel().MARGIN, 17), "Enter your name:", "#FFFFFF");
        drawText(gui, new Position(getModel().MARGIN, 19), getModel().getUsername(), "#FC6A03");
    }
}
