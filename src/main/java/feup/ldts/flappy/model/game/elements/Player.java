package feup.ldts.flappy.model.game.elements;

import feup.ldts.flappy.model.game.Position;

import java.util.List;

public class Player extends Element {
    private final static int gravity = 1;
    private final static int maxVelocity = 3;
    private int velocity = 1;

    public Player(Position position) {
        super(position);
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = Math.min(velocity, maxVelocity);
    }

    public int getGravity() {
        return gravity;
    }

    public List<Position> getPositions() {
        return List.of(
                new Position(this.getPosition().getX(), this.getPosition().getY()),
                new Position(this.getPosition().getX() + 1, this.getPosition().getY()),
                new Position(this.getPosition().getX(), this.getPosition().getY() + 1),
                new Position(this.getPosition().getX() + 1, this.getPosition().getY() + 1)
        );
    }
}
