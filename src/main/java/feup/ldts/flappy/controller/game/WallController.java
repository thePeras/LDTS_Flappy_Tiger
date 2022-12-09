package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Wall;

public class WallController extends Controller<Game> {

    private final Wall wall1, wall2;

    public WallController(Game game) {
        super(game);
        this.wall1 = game.getWall1();
        this.wall2 = game.getWall2();
    }

    public void updatePosition() {
        if(!getModel().isPlaying())
            return;
        wall1.setPosition(wall1.getPosition().addX(Wall.getSpeed()));
        wall2.setPosition(wall2.getPosition().addX(Wall.getSpeed()));
        if(wall1.getPosition().getX() < 0) {
            wall1.setX(wall2.getPosition().getX() + Game.distanceBetweenWalls);
            wall1.setHeight((int) (Math.random() * 15) + 3);
        }
        if(wall2.getPosition().getX() < 0) {
            wall2.setX(wall1.getPosition().getX() + Game.distanceBetweenWalls);
            wall2.setHeight((int) (Math.random() * 15) + 5);
        }
    }

    @Override
    public void step(App app, GUI.ACTION gui) {
        updatePosition();
    }

}
