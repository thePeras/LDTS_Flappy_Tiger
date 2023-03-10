package feup.ldts.flappy.controller.menu;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.sound.SoundEffects;
import feup.ldts.flappy.controller.sound.SoundManager;
import feup.ldts.flappy.model.menu.MainMenu;

import java.io.IOException;

import static feup.ldts.flappy.state.AppState.*;

public class MainMenuController extends MenuController<MainMenu> {

    public MainMenuController(MainMenu mainMenu) {
        super(mainMenu);
    }

    public void optionSelected(App game) throws IOException {
        SoundManager.getInstance().playSoundEffect(SoundEffects.MENU_CHOICE);
        if (getModel().isSelectedStart()) {
            game.setState(GAME_STATE);
            SoundManager.getInstance().playSoundEffect(SoundEffects.GAME_START);
            return;
        }
        if (getModel().isSelectedExit()) game.exit();
        if (getModel().isSelectedLeaderboard()) game.setState(LEADERBOARD_STATE);
        if (getModel().isSelectedInstructions()) game.setState(INSTRUCTIONS_STATE);
    }

    @Override
    public void escapePressed(App game) {
    }

    @Override
    public void backspacePressed(App game) {
    }
}
