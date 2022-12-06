package feup.ldts.flappy.model.game;

import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.Position;

public class Game {

    private boolean isPlaying;

    private final Player player;

    private final Wall wall;

    public Game() {
        this.isPlaying = false;
        this.player = new Player(new Position(9, LanternaGUI.height / 2 - 1));
        this.wall = new Wall();
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

    public Wall getWall() {
        return wall;
    }
}
