package feup.ldts.flappy.model.game;

import feup.ldts.flappy.model.Position;

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
}
