package feup.ldts.flappy.model.game;

import feup.ldts.flappy.model.Position;

public class Player extends Element {
    private int speed = 1;

    public Player(Position position) {
        super(position);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
