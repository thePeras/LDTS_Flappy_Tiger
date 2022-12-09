package feup.ldts.flappy.model.game;

import feup.ldts.flappy.model.game.Player;

public interface Collidable {
    public boolean isCollidingWithPlayer(Player player);
}
