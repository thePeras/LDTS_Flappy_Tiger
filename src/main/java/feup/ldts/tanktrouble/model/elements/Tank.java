package feup.ldts.tanktrouble.model.elements;

public class Tank extends Element {
    private int energy;

    public Tank(int x, int y) {
        super(x, y);
        this.energy = 10;
    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public int getEnergy() {
        return energy;
    }
}
