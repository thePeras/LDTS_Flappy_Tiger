package feup.ldts.tanktrouble.model.elements;

import feup.ldts.tanktrouble.model.Position;
import feup.ldts.tanktrouble.model.Vector;


public abstract class DynamicElement extends Element {

    private Vector velocity;
    private double angle;

    public DynamicElement(Position position, Vector velocity, double angle) {
        super(position);
        this.velocity = velocity;
        this.angle = angle;
    }

    public double getAngle(){return angle;}
}
