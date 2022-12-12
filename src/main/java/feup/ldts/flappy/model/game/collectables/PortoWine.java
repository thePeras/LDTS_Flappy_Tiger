package feup.ldts.flappy.model.game.collectables;

import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Player;
import feup.ldts.flappy.model.game.Position;

import java.util.List;

public class PortoWine extends Collectable{
    public PortoWine(Position position) {
        super(position);
    }

    public List<Position> getPositions(){
        return List.of(
                new Position(this.getPosition().getX(), this.getPosition().getY()),
                new Position(this.getPosition().getX(), this.getPosition().getY() + 1)
        );
    }

    @Override
    public void consume(Game game) {
        game.startGodMode();
    }

    @Override
    public boolean isCollidingWithPlayer(Player player) {
        return player.getPositions().stream().anyMatch(this.getPositions()::contains);
    }
}
