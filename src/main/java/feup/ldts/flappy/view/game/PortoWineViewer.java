package feup.ldts.flappy.view.game;

import feup.ldts.flappy.model.game.collectables.PortoWine;

public class PortoWineViewer implements ElementViewer<PortoWine> {
    @Override
    public void draw(PortoWine element, feup.ldts.flappy.gui.GUI gui) {
        gui.drawText(element.getPosition(), "P", "#FF0000");
    }
}
