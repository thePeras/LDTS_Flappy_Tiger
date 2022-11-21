package feup.ldts.tanktrouble.controller;

import feup.ldts.tanktrouble.Main;
import feup.ldts.tanktrouble.gui.GUI;
import feup.ldts.tanktrouble.model.Menu;
import feup.ldts.tanktrouble.model.arena.LoaderArenaBuilder;
import feup.ldts.tanktrouble.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Main game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousOption();
                break;
            case DOWN:
                getModel().nextOption();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
        }
    }
}
