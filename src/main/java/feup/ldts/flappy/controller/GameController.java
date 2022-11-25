package feup.ldts.flappy.controller;

import feup.ldts.flappy.App;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Game;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.MenuState;

public class GameController extends Controller{
    private Game game;
    public GameController(Game game) {
        this.game = game;
    }

    @Override
    public void step(App main, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException {
        if (action == GUI.ACTION.QUIT)
            main.setState(MenuState);
        else {
            //playerController.step(game, action);
        }
    }
}
