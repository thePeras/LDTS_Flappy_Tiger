package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Colors;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.collectables.Boar;

public class BoarViewer implements ElementViewer<Boar> {
    @Override
    public void draw(Boar element, GUI gui) {
        char boarChar = 134;
        for (Position position : element.getPositions()) {
            gui.drawPixel(position, boarChar++, Colors.BROWN.getHex(), Colors.BLUE.getHex());
        }
    }
}
