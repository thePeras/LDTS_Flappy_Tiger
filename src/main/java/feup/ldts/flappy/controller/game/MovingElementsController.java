package feup.ldts.flappy.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Wall;
import feup.ldts.flappy.model.game.collectables.Collectable;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

public class MovingElementsController extends Controller<Game> {
    public MovingElementsController(Game model) {
        super(model);
    }

    @Override
    public Game getModel() {
        return super.getModel();
    }

    private void moveWalls(){
        Iterator<Wall> wallIterator = getModel().getWalls().iterator();
        while (wallIterator.hasNext()){
            Wall wall = wallIterator.next();
            wall.move();
            if(wall.isOutOfScreen()){
                getModel().removeWall(wallIterator);
            }
        }
    }

    private void moveCollectables(){
        Iterator<Collectable> collectableIterator = getModel().getCollectables().iterator();
        while (collectableIterator.hasNext()){
            Collectable collectable = collectableIterator.next();
            collectable.move();
            if(collectable.isOutOfScreen()) {
                getModel().removeCollectable(collectableIterator);
            }
        }
    }

    @Override
    public void step(App app, KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        if(!getModel().isPlaying()) return;
        moveWalls();
        moveCollectables();
    }
}
