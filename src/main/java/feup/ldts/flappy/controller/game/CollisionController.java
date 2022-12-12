package feup.ldts.flappy.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Wall;
import feup.ldts.flappy.model.game.collectables.Collectable;
import feup.ldts.flappy.state.AppState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

public class CollisionController extends Controller<Game> {
    public CollisionController(Game model) {
        super(model);
    }

    @Override
    public void step(App app, KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        Iterator<Collectable> collectableIterator = getModel().getCollectables().iterator();
        while (collectableIterator.hasNext()){
            Collectable collectable = collectableIterator.next();
            if(collectable.isCollidingWithPlayer(getModel().getPlayer())){
                getModel().consumeCollectable(collectable);
                collectableIterator.remove();
            }
        }

        // TODO: Check if the player is colliding with the ground
        int groundY = getModel().getGround().getY();

        if(getModel().getPlayer().getPosition().getY() + 1 >= groundY){
            app.setState(AppState.GameOverState);
        }

        for(Wall wall : getModel().getWalls()){
            if(wall.isCollidingWithPlayer(getModel().getPlayer())){
                app.setState(AppState.GameOverState);
            }
        }
    }
}
