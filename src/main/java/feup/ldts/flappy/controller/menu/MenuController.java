package feup.ldts.flappy.controller.menu;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.controller.SoundManager;
import feup.ldts.flappy.gui.GUI;
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
    public void step(App game, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case UP:
                SoundManager.getInstance().playSoundEffect(SoundEffects.MENU_SELECT);
                getModel().previousOption();
                break;
            case DOWN:
                SoundManager.getInstance().playSoundEffect(SoundEffects.MENU_SELECT);
                getModel().nextOption();
                break;
            case SELECT:
                if (getModel().isSelectedStart()){
                    game.setState(GameState);
                    SoundManager.getInstance().playSoundEffect(SoundEffects.GAME_START);
                    return;
                }
                if (getModel().isSelectedExit()) game.exit();
                if (getModel().isSelectedLeaderboard()) game.setState(LeaderboardState);
                if (getModel().isSelectedInstructions()) game.setState(InstructionsState);
                SoundManager.getInstance().playSoundEffect(SoundEffects.MENU_CHOICE);
        }
    }
}
