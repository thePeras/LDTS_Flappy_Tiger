package feup.ldts.flappy.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.controller.SoundManager;
import feup.ldts.flappy.model.menu.MainMenu;
import feup.ldts.flappy.model.sound.SoundEffects;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.*;

public class MenuController extends Controller<MainMenu> {

    public MenuController(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void step(App game, KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        if (key == null) return;
        if (key.getKeyType() == KeyType.ArrowUp) {
            getModel().previousOption();
        } else if (key.getKeyType() == KeyType.ArrowDown) {
            getModel().nextOption();
        } else if (key.getKeyType() == KeyType.Enter) {
            SoundManager.getInstance().playSoundEffect(SoundEffects.MENU_CHOICE);
            if (getModel().isSelectedStart()) {
                game.setState(GameState);
                SoundManager.getInstance().playSoundEffect(SoundEffects.GAME_START);
                return;
            }
            if (getModel().isSelectedExit()) game.exit();
            if (getModel().isSelectedLeaderboard()) game.setState(LeaderboardState);
            if (getModel().isSelectedInstructions()) game.setState(InstructionsState);
        }
    }


}
