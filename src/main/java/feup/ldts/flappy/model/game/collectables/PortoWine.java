package feup.ldts.flappy.model.game.collectables;

import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Player;
import feup.ldts.flappy.model.game.Position;

public class PortoWine extends Collectable{
    public PortoWine(Position position) {
        super(position);
    }

    @Override
    public void consume(Game game) {
        game.setGodMode(true);
    }

    @Override
    public boolean isCollidingWithPlayer(Player player) {
        return player.getPositions().contains(this.getPosition());
    }
}
