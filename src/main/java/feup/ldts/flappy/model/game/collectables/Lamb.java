package feup.ldts.flappy.model.game.collectables;

import feup.ldts.flappy.model.game.Position;

import java.util.List;

public class Lamb extends Food{
    private final static int POINTS = 5;
    public Lamb(Position position) {
        super(position, POINTS);
    }

    public List<Position> getPositions(){
        return List.of(
                new Position(this.getPosition().getX(), this.getPosition().getY())
        );
    }
}
