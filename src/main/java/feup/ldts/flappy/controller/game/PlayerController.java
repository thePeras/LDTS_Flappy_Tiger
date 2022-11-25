package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Position;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Player;

public class PlayerController extends Controller<Game> {

    private final Player player;
    public PlayerController(Game game) {
        super(game);
        this.player = game.getPlayer();
    }

    public void jumpPlayer() {
        if(!getModel().isPlaying()) getModel().startPlaying();
        player.setVelocity(-3);
    }

    public void updatePosition() {
        if(!getModel().isPlaying()) return;
        Position position = player.getPosition();
        position.setY(position.getY() + player.getVelocity());
        player.setVelocity(player.getVelocity() + player.getGravity());

        if(position.getY() > 29){
            position.setY(29);
            player.setVelocity(0);
        }

        if(position.getY() < 0){
            position.setY(0);
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
