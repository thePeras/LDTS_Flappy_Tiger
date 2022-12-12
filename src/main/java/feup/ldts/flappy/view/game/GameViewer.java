package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Element;
import feup.ldts.flappy.model.game.Game;
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
        drawElement(gui, getModel().getPlayer(), new PlayerViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        //drawElements(gui, getModel().getCollectables(), new FoodViewer());
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
        gui.drawText(new Position(0,0), "Score: " + getModel().getScore(), "#FC6A03");
    }

    private void drawCollectables(GUI gui, List<Collectable> collectables) {
        for (Collectable collectable : collectables){
            if(collectable.getClass() == Lamb.class){
                new LambViewer().draw((Lamb) collectable, gui);
            }
            else if(collectable.getClass() == Boar.class){
                new BoarViewer().draw((Boar) collectable, gui);
            }
            else if(collectable.getClass() == PortoWine.class){
                new PortoWineViewer().draw((PortoWine) collectable, gui);
            }
        }
    }
}
