package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.elements.Player;
import feup.ldts.flappy.view.Colors;

public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player player, GUI gui) {
        char playerChar = 128;
        for (Position position : player.getPositions()) {
            gui.drawPixel(position, playerChar++, Colors.ORANGE.getHex(), Colors.BLUE.getHex());
        }
    }
}
