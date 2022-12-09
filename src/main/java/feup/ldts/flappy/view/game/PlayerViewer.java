package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.Player;

public class PlayerViewer implements ElementViewer<Player> {
    @Override
    public void draw(Player element, GUI gui) {
        drawPlayer(element.getPosition(), gui);
    }

    public static void drawPlayer(Position position, GUI gui) {
        gui.drawPixel(position.getX(), position.getY(), 'T', "#FFD700");
        gui.drawPixel(position.getX(), position.getY() + 1, 'T', "#FFD700");
        gui.drawPixel(position.getX() + 1, position.getY(), 'T', "#FFD700");
        gui.drawPixel(position.getX() + 1, position.getY() + 1, 'T', "#FFD700");
    }
}
