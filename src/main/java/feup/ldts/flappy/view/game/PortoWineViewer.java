package feup.ldts.flappy.view.game;

import feup.ldts.flappy.model.Colors;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.collectables.PortoWine;

public class PortoWineViewer implements ElementViewer<PortoWine> {
    @Override
    public void draw(PortoWine element, feup.ldts.flappy.gui.GUI gui) {
        int wineChar = 132;
        for(Position position : element.getPositions()) {
            gui.drawPixel(position, (char) wineChar++, Colors.DARK_BLUE.getHex(), Colors.BLUE.getHex());
        }
    }
}
