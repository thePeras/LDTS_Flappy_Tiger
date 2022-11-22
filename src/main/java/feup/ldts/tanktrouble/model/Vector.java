package feup.ldts.tanktrouble.model;

public class Vector extends Position{
    public Vector(int x, int y) {
        super(x, y);
    }

    public double module(){
        return Math.sqrt(getX()*getX() + getY()*getY());
    }
}
