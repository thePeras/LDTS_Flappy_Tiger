package feup.ldts.tanktrouble.viewer;

import feup.ldts.tanktrouble.gui.GUI;
import feup.ldts.tanktrouble.model.Position;
import feup.ldts.tanktrouble.model.arena.Arena;
import feup.ldts.tanktrouble.model.elements.Element;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getTank(), new TankViewer());

        gui.drawText(new Position(0, 0), "Energy: " + getModel().getTank().getEnergy(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
