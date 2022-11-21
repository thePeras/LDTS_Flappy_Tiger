package feup.ldts.tanktrouble.controller.game;

import feup.ldts.tanktrouble.Main;
import feup.ldts.tanktrouble.gui.GUI;
import feup.ldts.tanktrouble.model.Position;
import feup.ldts.tanktrouble.model.arena.Arena;

public class TankController extends GameController {
    public TankController(Arena arena) { super(arena); }

    public void moveTankLeft() {
        moveTank(getModel().getTank().getPosition().getLeft());
    }

    public void moveTankRight() {
        moveTank(getModel().getTank().getPosition().getRight());
    }

    public void moveTankUp() {
        moveTank(getModel().getTank().getPosition().getUp());
    }

    public void moveTankDown() {
        moveTank(getModel().getTank().getPosition().getDown());
    }

    private void moveTank(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getTank().setPosition(position);
        }
    }

    @Override
    public void step(Main game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveTankUp();
        if (action == GUI.ACTION.RIGHT) moveTankRight();
        if (action == GUI.ACTION.DOWN) moveTankDown();
        if (action == GUI.ACTION.LEFT) moveTankLeft();
    }
}
