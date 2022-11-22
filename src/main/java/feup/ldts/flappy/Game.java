package feup.ldts.flappy;

import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.controller.GameController;
import feup.ldts.flappy.controller.MenuController;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.Menu;
import feup.ldts.flappy.state.AppState;
import feup.ldts.flappy.view.GameViewer;
import feup.ldts.flappy.view.MenuViewer;
import feup.ldts.flappy.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static feup.ldts.flappy.state.AppState.MenuState;

public class Game {
    private final LanternaGUI gui;
    private Controller controller;
    private Viewer viewer;
    private AppState state;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(20, 20);
        this.state = MenuState;
        this.controller = new MenuController(new feup.ldts.flappy.model.Menu());
        this.viewer = new MenuViewer();
    }

    public static void main(String[] args){
        try{
            new Game().start();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setState(AppState state){
        this.state = state;
        switch(state){
            case MenuState:
                this.controller = new MenuController(new Menu());
                this.viewer = new MenuViewer();
                break;
            case GameState:
                this.controller = new GameController(new feup.ldts.flappy.model.Game());
                this.viewer = new GameViewer();
                break;
        }
    }
    private void start() throws Exception{
        int FPS = 10;
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
            }
        }

        gui.close();
    }
}