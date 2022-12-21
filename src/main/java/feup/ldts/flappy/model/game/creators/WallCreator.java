package feup.ldts.flappy.model.game.creators;

import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Element;
import feup.ldts.flappy.model.game.Wall;

import java.util.Random;

public class WallCreator extends Creator<Wall> {
    private final static int margin = 5;
    private Random random;
    public WallCreator() {this.random = new Random();}
    @Override
    public Wall create() {
        int randomHeight = random.nextInt((LanternaGUI.height - margin) / 2) + margin;
        return new Wall(randomHeight);
    }
}
