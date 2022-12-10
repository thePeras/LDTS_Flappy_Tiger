package feup.ldts.flappy.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
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
    public void step(App game, KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        if (key == null) return;
        if (key.equals(KeyType.ArrowUp)) {
            getModel().previousOption();
        } else if (key.equals(KeyType.ArrowDown)) {
            getModel().nextOption();
        } else if (key.equals(KeyType.Enter)) {
            if (getModel().isSelectedResume()) {
                game.setState(PrevGameState);
            }
            if (getModel().isSelectedRestart()) game.setState(GameState);
            if (getModel().isSelectedExit()) game.setState(MenuState);
        }
    }
}
