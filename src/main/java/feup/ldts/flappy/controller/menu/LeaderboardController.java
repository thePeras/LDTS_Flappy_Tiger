package feup.ldts.flappy.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.model.menu.Leaderboard;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.MenuState;

public class LeaderboardController extends Controller<Leaderboard> {
    private final Leaderboard leaderboard;

    public LeaderboardController(Leaderboard leaderboard) {
        super(leaderboard);
        this.leaderboard = leaderboard;
    }

    public void step(App game, KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        if (key == null) return;
        if (key.getKeyType() == KeyType.Escape) {
            game.setState(MenuState);
        }
    }
}



