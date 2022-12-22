package feup.ldts.flappy.model.game.collectables;

import feup.ldts.flappy.model.game.elements.Player;
import feup.ldts.flappy.model.game.Position;

import java.util.List;

public class Boar extends Food {
    private final static int POINTS = 3;

    public Boar(Position position) {
        super(position, POINTS);
    }

    public List<Position> getPositions() {
        return List.of(
                new Position(this.getPosition().getX(), this.getPosition().getY()),
                new Position(this.getPosition().getX() + 1, this.getPosition().getY())
        );
    }
}