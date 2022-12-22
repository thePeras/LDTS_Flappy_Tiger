package feup.ldts.flappy.model.game.elements;

import feup.ldts.flappy.model.game.Position;

public abstract class Element {
    private Position position;

    public Element(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
