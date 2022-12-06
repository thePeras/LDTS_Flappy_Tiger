package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Wall;

public class WallController extends Controller<Game> {

    private final Wall wall;

    public WallController(Game game) {
        super(game);
        this.wall = game.getWall();
    }

    public void updatePosition() {
        if(!getModel().isPlaying())
            return;
        wall.setPosition(wall.getPosition().addX(Wall.getSpeed()));
    }

    @Override
    public void step(App app, GUI.ACTION gui) {
        updatePosition();
    }

}
