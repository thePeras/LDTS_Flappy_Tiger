package feup.ldts.flappy.controller.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.controller.sound.SoundEffects;
import feup.ldts.flappy.controller.sound.SoundManager;
import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.elements.Collidable;
import feup.ldts.flappy.model.game.elements.Player;

public class PlayerController extends Controller<Game> {

    private final Player player;
    private int waitingCounter = 0;

    public PlayerController(Game game) {
        super(game);
        this.player = game.getPlayer();
    }

    public void jumpPlayer() {
        if (!getModel().isPlaying())
            getModel().startPlaying();
        if (player.getPosition().getY() < 0) return;
        player.setVelocity(-3);
        SoundManager.getInstance().playSoundEffect(SoundEffects.FLAP);
    }

    public void updatePosition() {
        Position position = player.getPosition();
        if (!getModel().isPlaying()) {
            if (waitingCounter == 0) {
                player.setVelocity(-player.getVelocity());
                position.setY(position.getY() + player.getVelocity());
            }
            waitingCounter = (waitingCounter + 1) % 11;
            return;
        }
        position.setY(position.getY() + player.getVelocity());
        player.setVelocity(player.getVelocity() + player.getGravity());

        if (position.getY() > LanternaGUI.HEIGHT - 1) {
            position.setY(LanternaGUI.HEIGHT - 1);
            player.setVelocity(0);
        }
    }

    public boolean isCollidingWith(Collidable collidable) {
        for (Position playerPosition : player.getPositions()) {
            for (Position elementPosition : collidable.getPositions()) {
                if (elementPosition.equals(playerPosition)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void step(App app, KeyStroke key) {
        updatePosition();
        if (key == null) return;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == ' ') {
            jumpPlayer();
        }
    }
}
