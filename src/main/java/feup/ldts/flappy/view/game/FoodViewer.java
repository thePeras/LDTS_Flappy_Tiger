package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.collectables.Collectable;

public class FoodViewer implements ElementViewer<Collectable> {
    @Override
    public void draw(Collectable element, GUI gui) {
        gui.drawText(element.getPosition(), "f", "#FF0000");
    }
}
