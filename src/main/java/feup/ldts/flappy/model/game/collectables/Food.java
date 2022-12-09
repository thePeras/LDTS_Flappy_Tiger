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
        for(Position position : player.getPositions()) {
            System.out.println("Player: " + position.getX() + " " + position.getY());
        }
        System.out.println("Food: " + this.getPosition().getX() + " " + this.getPosition().getY());
        return player.getPositions().contains(this.getPosition());
    }
}
