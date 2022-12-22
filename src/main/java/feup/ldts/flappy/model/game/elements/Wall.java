package feup.ldts.flappy.model.game.elements;

import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Position;

public class Wall extends Element implements Collidable {

    private final static int normalSpace = 11;
    private final static int speed = -1;
    private final static int width = 2;

    private int height;
    private int space;


    public Wall(int height) {
        super(new Position(LanternaGUI.width, 0));
        this.height = height;
        this.space = normalSpace;
    }

    public void setSpace(int newSpace) {
        this.space = newSpace;
        int newHeight = this.getHeight() - newSpace / 2;
        this.height = newHeight > 0 ? newHeight : 1;
    }

    public int getHeight() {
        return height;
    }

    public static int getSpeed() {
        return speed;
    }

    public static int getWidth() {
        return width;
    }

    public int getSpace(){
        return space;
    }

    public void setX(int x) {
        this.setPosition(new Position(x, this.getPosition().getY()));
    }

    public boolean isGapHeight(int y) {
        return y > this.height && y < this.height + this.space;
    }

    public boolean isOutOfScreen() {
        return this.getPosition().getX() < -1;
    }

    public void move() {
        this.setX(this.getPosition().getX() + getSpeed());
    }

    public boolean isCollidingWithPlayer(Player player) {
        for (int y = 0; y < LanternaGUI.height; y++) {
            if (isGapHeight(y)) continue;
            if (player.getPositions().contains(new Position(this.getPosition().getX(), y)) || player.getPositions().contains(new Position(this.getPosition().getX() + 1, y))) {
                return true;
            }
            if (player.getPosition().getY() < 0 && this.getPosition().getX() == player.getPosition().getX()) {
                return true;
            }
        }
        return false;
    }
}
