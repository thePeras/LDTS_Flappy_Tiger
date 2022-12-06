package feup.ldts.flappy.model.game;

import feup.ldts.flappy.model.Position;

public class Wall extends Element {
    private static int speed = -1;
    private final int height;
    private int space;

    public Wall(){
        super(new Position(30,0));
        this.height = 8;
        this.space = 12;
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

    public static void setSpeed(int speed) {
        Wall.speed = speed;
    }
}
