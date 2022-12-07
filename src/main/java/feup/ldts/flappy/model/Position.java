package feup.ldts.flappy.model;

public class Position {

    private int x, y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }

    public Position addX(int x) {
        this.x += x;
        return new Position(this.x, this.y);
    }

    public Position addY(int y) {
        this.y += y;
        return new Position(this.x, this.y);
    }
}
