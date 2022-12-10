package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Game;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.MenuState;
import static feup.ldts.flappy.state.AppState.PauseState;

public class GameController extends Controller<Game> {

    private final PlayerController playerController;
    private final CollisionController collisionController;
    private final ElementsFactory elementsFactory;
    private final MovingElementsController movingElementsController;

    public GameController(Game game) {
        super(game);
        this.playerController = new PlayerController(game);
        this.collisionController = new CollisionController(game);
        this.elementsFactory = new ElementsFactory(game);
        this.movingElementsController = new MovingElementsController(game);
    }

    private void updateScore() {

        int playerX = getModel().getPlayer().getPosition().getX();

        var walls = getModel().getWalls();


        for (var wall : walls) {
            int wallX = wall.getPosition().getX();

            if (playerX == wallX+1) {
                getModel().incrementScore();
                System.out.println(">>>>>>>> Score: " + getModel().getScore());
                break;
            }
        }
    }


    @Override
    public void step(App app, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException {
        if (action == GUI.ACTION.QUIT)
            app.setState(MenuState);
        if (action == GUI.ACTION.ESCAPE){
            getModel().setPlaying(false);
            app.setState(PauseState);
        }
        else {
            playerController.step(app, action);
            elementsFactory.step();
            movingElementsController.step(app, action);
            collisionController.step(app, action);
            updateScore();
        }
    }
}
