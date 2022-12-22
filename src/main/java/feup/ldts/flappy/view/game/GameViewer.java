package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.view.Colors;
import feup.ldts.flappy.model.game.elements.Element;
import feup.ldts.flappy.model.game.elements.Game;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.collectables.Boar;
import feup.ldts.flappy.model.game.collectables.Collectable;
import feup.ldts.flappy.model.game.collectables.Lamb;
import feup.ldts.flappy.model.game.collectables.PortoWine;
import feup.ldts.flappy.view.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Game> {
    public GameViewer(Game model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {
        drawSky(gui);
        drawElement(gui, getModel().getPlayer(), new PlayerViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getGround(), new GroundViewer());
        drawCollectables(gui, getModel().getCollectables());
        drawScore(gui);
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    private void drawScore(GUI gui) {
        String scoreText = "SCORE: " + getModel().getScore();
        gui.drawRectangle(new Position(0, 0), scoreText.length() + 2, 3, Colors.WHITE.getHex());
        gui.drawText(new Position(1, 1), scoreText, Colors.ORANGE.getHex(), Colors.WHITE.getHex());
    }

    private void drawCollectables(GUI gui, List<Collectable> collectables) {
        for (Collectable collectable : collectables) {
            if (collectable.getClass() == Lamb.class) {
                new LambViewer().draw((Lamb) collectable, gui);
            } else if (collectable.getClass() == Boar.class) {
                new BoarViewer().draw((Boar) collectable, gui);
            } else if (collectable.getClass() == PortoWine.class) {
                new PortoWineViewer().draw((PortoWine) collectable, gui);
            }
        }
    }

    private void drawSky(GUI gui) {
        gui.paintBackground(Colors.BLUE.getHex());
    }
}
