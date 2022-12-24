package feup.ldts.flappy.model.game.creators;

import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.elements.Wall;

import java.util.Random;

public class WallCreator extends Creator<Wall> {
    private final static int MARGIN = 5;
    private final Random random;

    public WallCreator() {
        this.random = new Random();
    }

    @Override
    public Wall create() {
        int randomHeight = random.nextInt((LanternaGUI.HEIGHT - MARGIN) / 2) + MARGIN;
        return new Wall(randomHeight);
    }
}
