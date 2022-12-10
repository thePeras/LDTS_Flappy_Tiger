package feup.ldts.flappy.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.model.menu.Instructions;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.MenuState;

public class InstructionsController extends Controller<Instructions> {
    private final Instructions instructions;

    public InstructionsController(Instructions instructions) {
        super(instructions);
        this.instructions = instructions;
    }

    @Override
    public void step(App game, KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        if (key == null) return;
        if (key.getKeyType() == KeyType.Escape) {
            game.setState(MenuState);
        }
    }
}
