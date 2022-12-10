package feup.ldts.flappy.model.game.collectables;

import feup.ldts.flappy.model.game.Collidable;
import feup.ldts.flappy.model.game.Element;
import feup.ldts.flappy.model.game.Position;

public abstract class Collectable extends Element implements Collidable {
    public Collectable(Position position) {
        super(position);
    }

    public abstract void consume();
}
