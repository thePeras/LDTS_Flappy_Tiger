package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.collectables.Collectable;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Wall;
import feup.ldts.flappy.state.AppState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

public class CollisionController extends Controller<Game> {
    public CollisionController(Game model) {
        super(model);
    }

    @Override
    public void step(App app, GUI.ACTION gui) throws IOException, URISyntaxException, FontFormatException {
        Iterator<Collectable> collectableIterator = getModel().getCollectables().iterator();
        while (collectableIterator.hasNext()){
            Collectable collectable = collectableIterator.next();
            if(collectable.isCollidingWithPlayer(getModel().getPlayer())){
                getModel().removeCollectable(collectableIterator);
            }
        }

        for(Wall wall : getModel().getWalls()){
            if(wall.isCollidingWithPlayer(getModel().getPlayer())){
                app.setState(AppState.MenuState);
            }
        }
    }
}
