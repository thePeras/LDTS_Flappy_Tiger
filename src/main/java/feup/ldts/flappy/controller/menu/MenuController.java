package feup.ldts.flappy.controller.menu;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.*;
import static java.awt.SystemColor.menu;

public class MenuController extends Controller<Menu> {
    
    public MenuController(Menu menu) {
        super(menu);
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
                if (getModel().isSelectedExit()) game.exit();
                if (getModel().isSelectedStart()) game.setState(GameState);
                if (getModel().isSelectedLeaderboard()) game.setState(LeaderboardState);
                if (getModel().isSelectedInstructions()) game.setState(InstructionsState);
        }
    }
}