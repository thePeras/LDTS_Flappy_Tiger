package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.view.Colors;
import feup.ldts.flappy.model.game.collectables.Lamb;

public class LambViewer implements ElementViewer<Lamb> {
    @Override
    public void draw(Lamb element, GUI gui) {
        gui.drawPixel(element.getPosition(), (char) 136, Colors.WHITE.getHex(), Colors.BLUE.getHex());
    }
}
