package feup.ldts.flappy.model.game;

public class Wall extends Element implements Collidable {
    private static int speed = -1;
    private int height;
    private int space;

    public Wall(int x) {
        super(new Position(x, 0));
        this.height = (int) (Math.random() * 15) + 3;
        this.space = 11;
    }

    public static int getSpeed() {
        return speed;
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

    public void setSpace(int space) {
        this.space = space;
    }

    public void setX(int x) {
        this.setPosition(new Position(x, this.getPosition().getY()));
    }

    public boolean isGapHeight(int y) {
        return y > this.height && y < this.height + this.space;
    }

    public boolean isCollidingWithPlayer(Player player) {
        //TODO: remove hardcoded 35 value
        for (int y = 0; y < 35; y++) {
            // print player positions

            if(isGapHeight(y)) continue;
            if (player.getPositions().contains(new Position(this.getPosition().getX(), y)) ||
                    player.getPositions().contains(new Position(this.getPosition().getX() + 1, y))) {
                System.out.println("COLLIDING2");
                return true;
            }
        }
        return false;
    }
}
