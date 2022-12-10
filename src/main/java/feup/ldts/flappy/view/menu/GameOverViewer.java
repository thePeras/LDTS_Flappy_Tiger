package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.GameOver;
import feup.ldts.flappy.view.Viewer;

import java.io.IOException;


public class GameOverViewer extends Viewer<GameOver> {

    public GameOverViewer(GameOver model) {
        super(model);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    @Override
    public void drawElements(GUI gui) {
        String gameOver = "G A M E   O V E R";
        String score = "Score :" + getModel().getScore();
        String outputName = "Enter your name:";
        gui.drawText(new Position(6, 13), gameOver, "#FF0000");
        gui.drawText(new Position(6, 15), score, "#FFFFFF");
        gui.drawText(new Position(6, 17), outputName, "#FFFFFF");
        gui.drawText(new Position(6, 19), getModel().getName(), "#FC6A03");
    }
}
