package feup.ldts.flappy.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.controller.SoundManager;
import feup.ldts.flappy.model.game.Game;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.PauseState;

public class GameController extends Controller<Game> {

    private final PlayerController playerController;
    private final CollisionController collisionController;
    private final ElementsFactory elementsFactory;
    private final MovingElementsController movingElementsController;

    public GameController(Game game) {
        super(game);
        this.playerController = new PlayerController(game);
        this.collisionController = new CollisionController(game);
        this.elementsFactory = new ElementsFactory(game);
        this.movingElementsController = new MovingElementsController(game);
    }

    private void updateScore() {
        int playerX = getModel().getPlayer().getPosition().getX();
        var walls = getModel().getWalls();

        for (var wall : walls) {
            int wallX = wall.getPosition().getX() + 1;

            if (playerX == wallX + 1) {
                getModel().incrementScore(1);
                break;
            }
        }
    }

    @Override
    public void step(App app, KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        if (key != null) {
            if (key.getKeyType() == KeyType.Escape) {
                getModel().setPlaying(false);
                app.setState(PauseState);
            }
            if (key.getKeyType() == KeyType.Character) {
                if (key.getCharacter() == 'p' || key.getCharacter() == 'q') {
                    getModel().setPlaying(false);
                    app.setState(PauseState);
                }
                if (key.getCharacter() == 'm') {
                    SoundManager.getInstance().toggleGameMusicMute();
                }
                if (key.getCharacter() == 's') {
                    SoundManager.getInstance().toggleSoundMute();
                }
            }
        }
        playerController.step(app, key);
        elementsFactory.step();
        movingElementsController.step(app, key);
        collisionController.step(app, key);
        updateScore();
    }
}
