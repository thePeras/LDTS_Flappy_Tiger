package feup.ldts.flappy.controller.menu;

import feup.ldts.flappy.App;
import feup.ldts.flappy.model.menu.TextMenu;

import java.io.IOException;

import static feup.ldts.flappy.state.AppState.MenuState;

public class TextMenuController extends MenuController<TextMenu> {

    public TextMenuController(TextMenu textMenu) {
        super(textMenu);
    }

    @Override
    public void escapePressed(App game) throws IOException {
        game.setState(MenuState);
    }

    @Override
    public void optionSelected(App game) {
    }

    @Override
    public void backspacePressed(App game) {
    }
}
