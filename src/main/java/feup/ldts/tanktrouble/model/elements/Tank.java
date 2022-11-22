package feup.ldts.tanktrouble.model.elements;

import feup.ldts.tanktrouble.model.Color;
import feup.ldts.tanktrouble.model.Position;
import feup.ldts.tanktrouble.model.Vector;

public class Tank extends DynamicElement {
    private int energy;
    private Color color;

    public Tank(Position position) {
        super(position, new Vector(10, 0), 0);
        this.energy = 10;
    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public int getEnergy() {
        return energy;
    }
}
