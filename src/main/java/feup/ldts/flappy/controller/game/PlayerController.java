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

    private void jumpPlayer() {
        if(!getModel().isPlaying()){
            getModel().startPlaying();
        }
        Position position = player.getPosition();
        player.setSpeed(-2);
        position.setY(position.getY() + player.getSpeed());
    }

    public void updatePosition() {
        if(!getModel().isPlaying()) return;
        Position position = player.getPosition();
        position.setY(position.getY() + player.getSpeed());
        player.setSpeed(player.getSpeed() + player.getGravity());

        if(position.getY() > 19){
            position.setY(19);
            player.setSpeed(0);
        }

        if(position.getY() < 0){
            position.setY(0);
            player.setSpeed(0);
        }
    }

    @Override
    public void step(App app, GUI.ACTION action) {
        updatePosition();
        if (action == GUI.ACTION.JUMP)
            jumpPlayer();
    }
}
