package feup.ldts.flappy.model.game.collectables;

import feup.ldts.flappy.model.game.Collidable;
import feup.ldts.flappy.model.game.Element;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Position;

public abstract class Collectable extends Element implements Collidable {
    private static final int speed = -1;
    public Collectable(Position position) {
        super(position);
    }

    public void move(){
        this.setPosition(this.getPosition().addX(speed));
    }

    public boolean isOutOfScreen() {
        return this.getPosition().getX() < -1;
    }
    public abstract void consume(Game game);
}
