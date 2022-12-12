package feup.ldts.flappy.model.game;

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

    public int getY() {
        return this.getPosition().getY();
    }
}
