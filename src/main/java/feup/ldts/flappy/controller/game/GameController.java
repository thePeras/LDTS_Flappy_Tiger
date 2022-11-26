package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.state.AppState;

import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.MenuState;
import static feup.ldts.flappy.state.AppState.PauseState;

public class GameController extends Controller<Game> {

    private final PlayerController playerController;

    public GameController(Game game) {
        super(game);
        this.playerController = new PlayerController(game);
    }

    @Override
    public void step(App app, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException {
        if (action == GUI.ACTION.QUIT)
            app.setState(MenuState);
        if (action == GUI.ACTION.ESCAPE){
            app.setState(PauseState);
        }
        else {
            playerController.step(app, action);
        }
    }
}
