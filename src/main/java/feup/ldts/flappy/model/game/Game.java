package feup.ldts.flappy.model.game;

import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.Position;

public class Game {

    private boolean isPlaying;

    private final Player player;

    private final Wall wall1, wall2;

    public static int distanceBetweenWalls = 20;

    public Game() {
        this.isPlaying = false;
        this.player = new Player(new Position(9, LanternaGUI.height / 2 - 1));
        this.wall1 = new Wall(LanternaGUI.width);
        this.wall2 = new Wall(LanternaGUI.width + distanceBetweenWalls);
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
    public void setPlaying(boolean playing){this.isPlaying = playing; }

    public void startPlaying() {
        isPlaying = true;
    }

    public Wall getWall1() {
        return wall1;
    }

    public Wall getWall2() {
        return wall2;
    }
}
