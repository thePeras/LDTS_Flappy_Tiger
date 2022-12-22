package feup.ldts.flappy.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.model.game.elements.Game;
import feup.ldts.flappy.model.game.elements.Wall;
import feup.ldts.flappy.model.game.collectables.Collectable;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

public class MovingElementsController extends Controller<Game> {
    public MovingElementsController(Game model) {
        super(model);
    }

    private void moveWalls() {
        Iterator<Wall> wallIterator = getModel().getWalls().iterator();
        while (wallIterator.hasNext()) {
            Wall wall = wallIterator.next();
            wall.move();
            if (wall.isOutOfScreen()) {
                getModel().removeWall(wallIterator);
            }
        }
    }

    private void moveCollectables() {
        Iterator<Collectable> collectableIterator = getModel().getCollectables().iterator();
        while (collectableIterator.hasNext()) {
            Collectable collectable = collectableIterator.next();
            collectable.move();
            if (collectable.isOutOfScreen()) {
                getModel().removeCollectable(collectableIterator);
            }
        }
    }

    @Override
    public void step(App app, KeyStroke key) {
        if (!getModel().isPlaying()) return;
        moveWalls();
        moveCollectables();
    }
}
