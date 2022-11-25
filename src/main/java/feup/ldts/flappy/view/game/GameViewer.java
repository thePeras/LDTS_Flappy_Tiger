package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Element;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.view.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Game> {
    public GameViewer(Game model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElement(gui, getModel().getPlayer(), new PlayerViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
