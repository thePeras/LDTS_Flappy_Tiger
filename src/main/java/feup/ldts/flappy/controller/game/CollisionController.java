package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Collectables.Collectable;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Wall;
import feup.ldts.flappy.state.AppState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class CollisionController extends Controller<Game> {
    public CollisionController(Game model) {
        super(model);
    }

    @Override
    public void step(App app, GUI.ACTION gui) throws IOException, URISyntaxException, FontFormatException {
        List<Collectable> arenaCollectables = getModel().getCollectables();

        //For each element detects if it collides with the player
        for(Collectable collectable : arenaCollectables){
            //if(collectable.isCollidingWithPlayer(getModel().getPlayer())){
            //
            //    getModel().removeCollectable(collectable);
            //}
        }

        List<Wall> arenaWalls = getModel().getWalls();
        for(Wall wall : arenaWalls){
            if(wall.isCollidingWithPlayer(getModel().getPlayer())){
                app.setState(AppState.MenuState);
            }
        }


    }
}
