package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Player;

public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player element, GUI gui) {
        gui.drawPlayer(element.getPosition());
    }
}
