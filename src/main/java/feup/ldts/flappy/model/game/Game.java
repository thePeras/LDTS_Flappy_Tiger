package feup.ldts.flappy.model.game;

import feup.ldts.flappy.model.Position;

public class Game {

    private final Player player;

    public Game() {
        this.player = new Player(new Position(9, 9));
    }

    public Player getPlayer() {
        return player;
    }
}
