package feup.ldts.flappy.model.game.collectables;

import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.Player;

public class Food extends Collectable {
    private int points;

    public Food(Position position, int points) {
        super(position);
        this.points = points;
    }
    @Override
    public void consume() {

    }

    @Override
    public boolean isCollidingWithPlayer(Player player) {
        return false;
    }
}
