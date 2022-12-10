package feup.ldts.flappy.model.game.collectables;

import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Player;
import feup.ldts.flappy.model.game.Position;

public class Food extends Collectable {
    private int points;

    public Food(Position position, int points) {
        super(position);
        this.points = points;
    }

    @Override
    public void consume(Game game) {
        game.incrementScore(points);
    }

    @Override
    public boolean isCollidingWithPlayer(Player player) {
        return player.getPositions().contains(this.getPosition());
    }
}
