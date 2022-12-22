package feup.ldts.flappy.controller.menu;

import feup.ldts.flappy.App;
import feup.ldts.flappy.model.menu.Pause;

import java.io.IOException;

import static feup.ldts.flappy.state.AppState.*;

public class PauseController extends MenuController<Pause> {

    public PauseController(Pause pause) {
        super(pause);
    }

    public void optionSelected(App game) throws IOException {
        if (getModel().isSelectedResume()) {
            game.setState(PrevGameState);
        }
        if (getModel().isSelectedRestart()) game.setState(GameState);
        if (getModel().isSelectedExit()) game.setState(MenuState);
    }

    @Override
    public void escapePressed(App game) throws IOException {
        game.setState(PrevGameState);
    }

    @Override
    public void backspacePressed(App game) {
    }
}
