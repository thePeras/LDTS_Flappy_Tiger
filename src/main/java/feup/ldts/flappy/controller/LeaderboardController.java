package feup.ldts.flappy.controller;

import feup.ldts.flappy.App;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.menu.Leaderboard;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.*;

public class LeaderboardController extends Controller{
    private Leaderboard leaderboard;
    public LeaderboardController(Leaderboard leaderboard) {
        this.leaderboard = leaderboard;
    }
    @Override
    public void step(App game, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case ESCAPE :
                game.setState(MenuState);
        }
    }
}



