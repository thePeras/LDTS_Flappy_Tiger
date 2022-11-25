package feup.ldts.flappy.model.game;

import feup.ldts.flappy.model.Position;

public class Game {

    private boolean isPlaying;

    private final Player player;

    public Game() {
        this.isPlaying = false;
        this.player = new Player(new Position(9, 9));
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
}
