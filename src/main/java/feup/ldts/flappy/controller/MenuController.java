package feup.ldts.flappy.controller;

import feup.ldts.flappy.Game;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Menu;

import static feup.ldts.flappy.state.AppState.GameState;

public class MenuController extends Controller {
    private Menu menu;

    public MenuController(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void step(Game game, GUI.ACTION action){
        switch (action) {
            case UP:
                menu.previousOption();
                break;
            case DOWN:
                menu.nextOption();
                break;
            case SELECT:
                if (menu.isSelectedExit()) game.setState(null);
                if (menu.isSelectedStart()) game.setState(GameState);
        }
    }
}
