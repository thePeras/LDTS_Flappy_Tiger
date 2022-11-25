package feup.ldts.flappy.controller.menu;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.menu.Instructions;
import feup.ldts.flappy.model.menu.Leaderboard;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import static feup.ldts.flappy.state.AppState.MenuState;

public class InstructionsController extends Controller<Instructions> {
    private final Instructions instructions;

    public InstructionsController(Instructions instructions) {
        super(instructions);
        this.instructions = instructions;
    }


    @Override
    public void step(App game, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException {
        if (Objects.requireNonNull(action) == GUI.ACTION.ESCAPE) {
            game.setState(MenuState);
        }
    }
}
