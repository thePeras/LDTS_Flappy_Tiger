package feup.ldts.flappy;

import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.controller.game.GameController;
import feup.ldts.flappy.controller.menu.MenuController;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.menu.Menu;
import feup.ldts.flappy.state.AppState;
import feup.ldts.flappy.view.game.GameViewer;
import feup.ldts.flappy.view.menu.MenuViewer;
import feup.ldts.flappy.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.GameState;
import static feup.ldts.flappy.state.AppState.MenuState;

public class App {
    private final LanternaGUI gui;
    private Controller controller;
    private Viewer viewer;
    private AppState state;
    private Menu menu;
    private Game game;

    public App() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(30, 30);
        this.state = GameState;
        this.game = new Game();
        this.controller = new GameController(game);
        this.viewer = new GameViewer(game);
    }

    public static void main(String[] args){
        try{
            new App().start();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setState(AppState state) throws IOException, URISyntaxException, FontFormatException {
        this.state = state;
        switch(state){
            case MenuState:
                this.controller = new MenuController(menu);
                this.viewer = new MenuViewer(menu);
                break;
            case GameState:
                this.game = new Game();
                this.controller = new GameController(game);
                this.viewer = new GameViewer(game);
                break;
        }
    }
    private void start() throws Exception{
        int FPS = 14;
        int frameTime = 1000 / FPS;
        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            GUI.ACTION action = gui.getNextAction();
            controller.step(this, action);
            viewer.draw(gui);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gui.close();
    }
}