package feup.ldts.flappy.controller;

import feup.ldts.flappy.Game;
import feup.ldts.flappy.gui.GUI;

import static feup.ldts.flappy.state.AppState.MenuState;

public class GameController extends Controller{
    private feup.ldts.flappy.model.Game game;
    public GameController(feup.ldts.flappy.model.Game game) {
        this.game = game;
    }

    @Override
    public void step(Game main, GUI.ACTION action) {
        if (action == GUI.ACTION.QUIT)
            main.setState(MenuState);
        else {
            //playerController.step(game, action);
        }
    }
}
