package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.GameOver;
import feup.ldts.flappy.view.Colors;

public class GameOverViewer extends MenuViewer<GameOver> {

    public GameOverViewer(GameOver model) {
        super(model, new Position(model.MARGIN - 1, 21));
    }

    public void drawInsideElements(GUI gui) {
        drawText(gui, new Position(getModel().MARGIN, 13), "G A M E   O V E R", Colors.ORANGE.getHex());
        drawText(gui, new Position(getModel().MARGIN, 15), "Score: " + getModel().getScore(), Colors.WHITE.getHex());
        drawText(gui, new Position(getModel().MARGIN, 17), "Enter your name:", Colors.WHITE.getHex());
        drawText(gui, new Position(getModel().MARGIN, 19), getModel().getUsername(), Colors.ORANGE.getHex());
    }
}
