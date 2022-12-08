package feup.ldts.flappy;

import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.controller.game.GameController;
import feup.ldts.flappy.controller.menu.InstructionsController;
import feup.ldts.flappy.controller.menu.LeaderboardController;
import feup.ldts.flappy.controller.menu.MenuController;
import feup.ldts.flappy.controller.menu.PauseController;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.File;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.menu.Instructions;
import feup.ldts.flappy.model.menu.Leaderboard;
import feup.ldts.flappy.model.menu.MainMenu;
import feup.ldts.flappy.model.menu.Pause;
import feup.ldts.flappy.state.AppState;
import feup.ldts.flappy.view.Viewer;
import feup.ldts.flappy.view.game.GameViewer;
import feup.ldts.flappy.view.menu.InstructionsViewer;
import feup.ldts.flappy.view.menu.LeaderboardViewer;
import feup.ldts.flappy.view.menu.MenuViewer;
import feup.ldts.flappy.view.menu.PauseViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import static feup.ldts.flappy.state.AppState.MenuState;
import static feup.ldts.flappy.state.AppState.PauseState;

public class App {
    private final LanternaGUI gui;
    private Controller controller;

    private Viewer viewer;
    private AppState state;
    private MainMenu mainMenu;
    private Pause pause;
    private Game game;
    private Game prevGame;
    private File curiosities = new File("src/main/resources/curiosities.txt");



    public App() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(); 
        this.state = MenuState;
        this.mainMenu = new MainMenu(curiosities.readCuriosities());
        this.controller = new MenuController(mainMenu);
        this.viewer = new MenuViewer(mainMenu);
    }

    public static void main(String[] args) {
        try {
            new App().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setState(AppState state) throws IOException, URISyntaxException, FontFormatException {
        if(state == PauseState){
            this.prevGame = this.game;
        }
        this.state = state;
        switch (state) {
            case MenuState:

                this.mainMenu = new MainMenu(curiosities.readCuriosities());
                this.controller = new MenuController(mainMenu);
                this.viewer = new MenuViewer(mainMenu);
                break;
            case GameState:
                this.game = new Game();
                this.controller = new GameController(game);
                this.viewer = new GameViewer(game);
                break;
            case LeaderboardState:
                File leaderboardFile = new File("src/main/resources/leaderboard.txt");
                String[] names = leaderboardFile.readFile();
                Leaderboard leaderboard = new Leaderboard(names);
                this.controller = new LeaderboardController(leaderboard);
                this.viewer = new LeaderboardViewer(leaderboard);
                break;
            case InstructionsState:
                Instructions instructions = new Instructions();
                this.controller = new InstructionsController(instructions);
                this.viewer = new InstructionsViewer(instructions);
                break;
            case PauseState:
                this.pause = new Pause();
                this.controller = new PauseController(pause);
                this.viewer = new PauseViewer(pause);
                break;
            case PrevGameState:
                this.game = this.prevGame;
                this.controller = new GameController(game);
                this.viewer = new GameViewer(game);
                break;
        }
    }
    private void start() throws Exception {
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

    public void exit() {
        this.state = null;
    }

    public void showLeaderboard() {
    }

    public AppState getState() {
        return state;
    }
}