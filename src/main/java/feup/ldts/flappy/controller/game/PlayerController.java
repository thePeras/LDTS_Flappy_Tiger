package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.controller.SoundManager;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Player;
import feup.ldts.flappy.model.sound.SoundEffects;

public class PlayerController extends Controller<Game> {

    private int waitingCounter = 0;

    private final Player player;
    public PlayerController(Game game) {
        super(game);
        this.player = game.getPlayer();
    }

    public void jumpPlayer() {
        if(!getModel().isPlaying())
            getModel().startPlaying();
        player.setVelocity(-3);
        SoundManager.getInstance().playSoundEffect(SoundEffects.FLAP);
    }

    public void updatePosition() {
        Position position = player.getPosition();
        if(!getModel().isPlaying()) {
            if(waitingCounter == 0){
                player.setVelocity(-player.getVelocity());
                position.setY(position.getY() + player.getVelocity());
            }
            waitingCounter = (waitingCounter + 1) % 11;
            return;
        }
        position.setY(position.getY() + player.getVelocity());
        player.setVelocity(player.getVelocity() + player.getGravity());

        if(position.getY() > LanternaGUI.height - 1) {
            position.setY(29);
            player.setVelocity(0);
        }
    }

    @Override
    public void step(App app, GUI.ACTION action) {
        updatePosition();
        if (action == GUI.ACTION.JUMP)
            jumpPlayer();
    }
}
