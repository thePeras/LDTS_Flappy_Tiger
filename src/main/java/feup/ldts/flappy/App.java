package feup.ldts.flappy;

import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.controller.game.GameController;
import feup.ldts.flappy.controller.menu.InstructionsController;
import feup.ldts.flappy.controller.menu.LeaderboardController;
import feup.ldts.flappy.controller.menu.MenuController;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.menu.Instructions;
import feup.ldts.flappy.model.menu.Leaderboard;
import feup.ldts.flappy.model.menu.Menu;
import feup.ldts.flappy.state.AppState;
import feup.ldts.flappy.view.Viewer;
import feup.ldts.flappy.view.game.GameViewer;
import feup.ldts.flappy.view.menu.InstructionsViewer;
import feup.ldts.flappy.view.menu.LeaderboardViewer;
import feup.ldts.flappy.view.menu.MenuViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import static feup.ldts.flappy.state.AppState.MenuState;

public class App {
    private final LanternaGUI gui;
    private Controller controller;
    private Viewer viewer;
    private AppState state;
    private Menu menu;
    private Game game;

    public App() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(); 
        this.state = MenuState;
        this.menu = new Menu();
        this.controller = new MenuController(menu);
        this.viewer = new MenuViewer(menu);
    }

    public static void main(String[] args) {
        try {
            new App().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setState(AppState state) throws IOException, URISyntaxException, FontFormatException {
        this.state = state;
        switch (state) {
            case MenuState:
                this.menu = new Menu();
                this.controller = new MenuController(menu);
                this.viewer = new MenuViewer(menu);
                break;
            case GameState:
                this.game = new Game();
                this.controller = new GameController(game);
                this.viewer = new GameViewer(game);
                break;
            case LeaderboardState:
                //Create a string vector with the names of the players and scores
                String[] names = readLeaderboard();
                this.menu = new Leaderboard(names);
                this.controller = new LeaderboardController((Leaderboard) menu);
                this.viewer = new LeaderboardViewer((Leaderboard) menu);
                break;
            case InstructionsState:
                this.menu = new Instructions();
                this.controller = new InstructionsController((Instructions) menu);
                this.viewer = new InstructionsViewer((Instructions) menu);
        }
    }

    private String[] readLeaderboard() throws IOException {
        //Read the contents of a file and return a string vector with the names and scores
        Path path = Path.of("src/main/resources/leaderboard.txt");
        String contents = Files.readString(path);
        //sort the contents
        String[] names = contents.split("\n");
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (Integer.parseInt(names[i].split(" ")[0]) < Integer.parseInt(names[j].split(" ")[0])) {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        //print the contents of the file
        return names;
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
}