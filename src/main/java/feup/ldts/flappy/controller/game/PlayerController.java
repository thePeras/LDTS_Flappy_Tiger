package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.App;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Position;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Player;

public class PlayerController extends GameController{
    public PlayerController(Game game) {
        super(game);
    }

    private void jumpPlayer() {
        if(!getModel().isPlaying()) {
            getModel().startPlaying();
        }

        Player player = getModel().getPlayer();
        Position position = player.getPosition();
        player.setSpeed(0);
        position.setY(position.getY() + player.getSpeed());
    }

    @Override
    public void step(App app, GUI.ACTION action) {
        if (action == GUI.ACTION.JUMP)
            jumpPlayer();
    }
}
