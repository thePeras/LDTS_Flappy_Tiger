package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.Player;

public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player player, GUI gui) {
        for(Position position : player.getPositions()) {
            gui.drawPixel(position, 'T', "#FFFFFF");
        }
    }
}
