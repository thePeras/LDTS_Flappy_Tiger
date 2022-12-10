package feup.ldts.flappy.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.model.game.Game;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.PauseState;

public class GameController extends Controller<Game> {

    private final PlayerController playerController;
    private final WallController wallController;
    private final CollisionController collisionController;

    public GameController(Game game) {
        super(game);
        this.playerController = new PlayerController(game);
        this.wallController = new WallController(game);
        this.collisionController = new CollisionController(game);
    }

    @Override
    public void step(App app, KeyStroke key) throws IOException, URISyntaxException, FontFormatException {

        if (key != null && key.getKeyType() == KeyType.Escape) {
            getModel().setPlaying(false);
            app.setState(PauseState);
        } else {
            playerController.step(app, key);
            wallController.step(app, key);
            collisionController.step(app, key);
        }
    }
}
