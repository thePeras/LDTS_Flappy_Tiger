package feup.ldts.flappy.controller.menu;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.menu.Pause;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.*;

public class PauseController extends Controller<Pause> {

        public PauseController(Pause pause) {
            super(pause);
        }
    @Override
    public void step(App game, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case UP:
                getModel().previousOption();
                break;
            case DOWN:
                getModel().nextOption();
                break;
            case SELECT:
                if (getModel().isSelectedResume()) game.exit();
                if (getModel().isSelectedRestart()) game.setState(GameState);
                if (getModel().isSelectedExit()) game.setState(MenuState);
        }
    }
}
