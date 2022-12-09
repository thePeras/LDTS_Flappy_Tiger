package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.GameOver;
import feup.ldts.flappy.model.menu.MainMenu;
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
        String score = "Score : 500" ;
        String outputName = "Enter your name:";
        gui.drawText(new Position(8, 11), gameOver, "#FC6A03");
        gui.drawText(new Position(8, 13), score, "#FC6A03");
        gui.drawText(new Position(8, 15), outputName, "#FC6A03");
    }
}
