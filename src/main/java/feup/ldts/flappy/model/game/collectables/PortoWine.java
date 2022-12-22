package feup.ldts.flappy.model.game.collectables;

import feup.ldts.flappy.model.game.elements.Game;
import feup.ldts.flappy.model.game.elements.Player;
import feup.ldts.flappy.model.game.Position;

import java.util.List;

public class PortoWine extends Collectable {
    public PortoWine(Position position) {
        super(position);
    }

    public List<Position> getPositions() {
        return List.of(
                new Position(this.getPosition().getX(), this.getPosition().getY()),
                new Position(this.getPosition().getX(), this.getPosition().getY() + 1)
        );
    }

    @Override
    public void consume(Game game) {
        game.startGodMode();
    }

    // TODO: extract this method to collectable abstract class
    @Override
    public boolean isCollidingWithPlayer(Player player) {
        for (Position playerPosition : player.getPositions()) {
            for (Position winePosition : this.getPositions()) {
                if (winePosition.equals(playerPosition)) {
                    return true;
                }
            }
        }
        return false;
    }
}
