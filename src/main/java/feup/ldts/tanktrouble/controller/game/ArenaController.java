package feup.ldts.tanktrouble.controller.game;

import feup.ldts.tanktrouble.Main;
import feup.ldts.tanktrouble.gui.GUI;
import feup.ldts.tanktrouble.model.Menu;
import feup.ldts.tanktrouble.model.arena.Arena;
import feup.ldts.tanktrouble.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final TankController tankController;

    public ArenaController(Arena arena) {
        super(arena);

        this.tankController = new TankController(arena);
    }

    public void step(Main game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getTank().getEnergy() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            tankController.step(game, action, time);
        }
    }
}