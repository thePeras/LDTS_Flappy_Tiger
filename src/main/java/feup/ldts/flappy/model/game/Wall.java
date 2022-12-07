package feup.ldts.flappy.model.game;

import feup.ldts.flappy.model.Position;

public class Wall extends Element {
    private static int speed = -1;
    private int height;
    private int space;

    public Wall(int x) {
        super(new Position(x, 0));
        this.height = (int) (Math.random() * 15) + 3;
        this.space = 11;
    }

    public int getHeight() {
        return height;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public static int getSpeed() {
        return speed;
    }

    public void setX(int x) {
        this.setPosition(new Position(x, this.getPosition().getY()));
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
