package feup.ldts.flappy.model.game.collectables;

import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Position;

public abstract class Food extends Collectable {
    private final int points;

    public Food(Position position, int points) {
        super(position);
        this.points = points;
    }

    @Override
    public void consume(Game game) {
        game.incrementScore(points);
    }
}
