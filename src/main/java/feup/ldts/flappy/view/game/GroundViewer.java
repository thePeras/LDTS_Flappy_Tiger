package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.elements.Ground;
import feup.ldts.flappy.view.Colors;

public class GroundViewer implements ElementViewer<Ground> {
    @Override
    public void draw(Ground ground, GUI gui) {
        int groundY = ground.getPosition().getY();
        for (int x = 0; x <= gui.getWidth(); x++) {
            gui.paintPixel(new Position(x, groundY), Colors.DARK_GREEN.getHex());
        }
    }
}
