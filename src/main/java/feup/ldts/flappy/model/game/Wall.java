package feup.ldts.flappy.model.game;

import feup.ldts.flappy.gui.LanternaGUI;

public class Wall extends Element implements Collidable {
    private final static int speed = -1;
    private int height;
    private final static int space = 11;

    public Wall(int height) {
        super(new Position(LanternaGUI.width, 0));
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpace() {
        return space;
    }

    public static int getSpeed() {
        return speed;
    }

    public void setX(int x) {
        this.setPosition(new Position(x, this.getPosition().getY()));
    }

    public boolean isGapHeight(int y) {
        return y > this.height && y <= this.height + this.space;
    }

    public boolean isOutOfScreen() {
        return this.getPosition().getX() < -1;
    }
    public void move() {
        this.setX(this.getPosition().getX() + getSpeed());
    }

    public boolean isCollidingWithPlayer(Player player) {
        for (int y = 0; y < LanternaGUI.height; y++) {
            if(isGapHeight(y)) continue;
            if (player.getPositions().contains(new Position(this.getPosition().getX(), y)) ||
                    player.getPositions().contains(new Position(this.getPosition().getX() + 1, y))) {
                return true;
            }
            if(player.getPosition().getY() < 0 && this.getPosition().getX() == player.getPosition().getX()) {
                return true;
            }
        }
        return false;
    }
}
