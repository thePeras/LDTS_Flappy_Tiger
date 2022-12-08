package feup.ldts.flappy.model.game.Collectables;

import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.Player;

public class Deer extends Collectable {
    final static int points = 10;

    public Deer(Position position) {
        super(position);
    }
    @Override
    public void consume() {

    }

    @Override
    public boolean isCollidingWithPlayer(Player player) {
        return false;
    }
}
