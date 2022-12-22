package feup.ldts.flappy.model.game.elements;

import feup.ldts.flappy.model.game.Position;

public class Ground extends Element implements Collidable {

    public Ground(int y) {
        super(new Position(0, y));
    }

    @Override
    public boolean isCollidingWithPlayer(Player player) {
        for (Position position : player.getPositions()) {
            if (position.getY() == this.getPosition().getY()) {
                return true;
            }
        }
        return false;
    }
}
