package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.collectables.Lamb;

public class LambViewer implements ElementViewer<Lamb> {
    @Override
    public void draw(Lamb element, GUI gui) {
        gui.drawText(element.getPosition(), "L", "#FF0000");
    }
}
