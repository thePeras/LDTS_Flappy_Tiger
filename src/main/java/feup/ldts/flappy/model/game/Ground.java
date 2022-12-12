package feup.ldts.flappy.model.game;

public class Ground extends Element {

    public Ground(int y) {
        super(new Position(0, y));
    }

    public Boolean isCollidingWithPlayer(Player player) {
        return player.getPosition().getY() == this.getPosition().getY();
    }

    public int getY() {
        return this.getPosition().getY();
    }
}
