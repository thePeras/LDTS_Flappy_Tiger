package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.collectables.Boar;

public class BoarViewer implements ElementViewer<Boar> {
    @Override
    public void draw(Boar element, GUI gui) {
        gui.drawText(element.getPosition(), "B", "#FF0000");
    }
}
