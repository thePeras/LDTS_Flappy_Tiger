package feup.ldts.flappy.model.game.collectables;

import feup.ldts.flappy.model.game.Position;

public class Lamb extends Food{
    private final static int POINTS = 5;
    public Lamb(Position position) {
        super(position, POINTS);
    }
}
