package feup.ldts.flappy.model.game;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        Position position = (Position) obj;
        return position.getX() == this.getX() && position.getY() == this.getY();
    }

    @Override
    public int hashCode() {
        return x * 31 + y;
    }
}
