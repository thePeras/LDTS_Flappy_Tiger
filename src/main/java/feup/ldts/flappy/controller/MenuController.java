package feup.ldts.flappy.controller;

import feup.ldts.flappy.App;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.GameState;
import static feup.ldts.flappy.state.AppState.LeaderboardState;

public class MenuController extends Controller {
    private final Menu menu;

    public MenuController(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void step(App game, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case UP:
                menu.previousOption();
                break;
            case DOWN:
                menu.nextOption();
                break;
            case SELECT:
                if (menu.isSelectedExit()) game.exit();
                if (menu.isSelectedStart()) game.setState(GameState);
                if (menu.isSelectedLeaderboard()) game.setState(LeaderboardState);
        }
    }
}
