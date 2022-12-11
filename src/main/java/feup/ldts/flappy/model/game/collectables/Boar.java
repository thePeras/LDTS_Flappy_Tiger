package feup.ldts.flappy.model.game.collectables;

import feup.ldts.flappy.model.game.Position;

public class Boar extends Food{
    private final static int POINTS = 3;
    public Boar(Position position) {
        super(position, POINTS);
    }
}