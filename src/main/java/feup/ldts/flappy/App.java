package feup.ldts.flappy;

import com.googlecode.lanterna.input.KeyStroke;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.controller.sound.SoundManager;
import feup.ldts.flappy.controller.game.GameController;
import feup.ldts.flappy.controller.menu.*;
import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.elements.Game;
import feup.ldts.flappy.model.menu.*;
import feup.ldts.flappy.controller.sound.Musics;
import feup.ldts.flappy.state.AppState;
import feup.ldts.flappy.view.Viewer;
import feup.ldts.flappy.view.game.GameViewer;
import feup.ldts.flappy.view.menu.*;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

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

    public App() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI();
        this.state = MenuState;
        this.mainMenu = new MainMenu();
        this.controller = new MainMenuController(mainMenu);
        this.viewer = new MainMenuViewer(mainMenu);
        SoundManager.getInstance().setBackgroundSound(Musics.MENU_MUSIC);
    }

    public static void main(String[] args) {
        try {
            new App().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() throws Exception {
        int FPS = 14;
        int frameTime = 1000 / FPS;
        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            KeyStroke next_key = gui.getNextAction();

            controller.step(this, next_key);
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
        SoundManager.getInstance().stopAll();
    }

    public void setState(AppState state) throws IOException {
        if (state == PauseState) {
            this.prevGame = this.game;
        }
        this.state = state;
        switch (state) {
            case MenuState:
                SoundManager.getInstance().setBackgroundSound(Musics.MENU_MUSIC);
                this.mainMenu = new MainMenu();
                this.controller = new MainMenuController(mainMenu);
                this.viewer = new MainMenuViewer(mainMenu);
                break;
            case GameState:
                SoundManager.getInstance().setBackgroundSound(Musics.GAME_MUSIC);
                this.game = new Game();
                this.controller = new GameController(game);
                this.viewer = new GameViewer(game);
                break;
            case PrevGameState:
                SoundManager.getInstance().resumeBackgroundSound();
                this.game = this.prevGame;
                this.controller = new GameController(game);
                this.viewer = new GameViewer(game);
                break;
            case LeaderboardState:
                Leaderboard leaderboard = new Leaderboard();
                this.controller = new TextMenuController(leaderboard);
                this.viewer = new LeaderboardViewer(leaderboard);
                break;
            case InstructionsState:
                Instructions instructions = new Instructions();
                this.controller = new TextMenuController(instructions);
                this.viewer = new InstructionsViewer(instructions);
                break;
            case PauseState:
                SoundManager.getInstance().pauseBackgroundSound();
                this.pause = new Pause();
                this.controller = new PauseController(pause);
                this.viewer = new PauseViewer(pause);
                break;
            case GameOverState:
                SoundManager.getInstance().pauseBackgroundSound();
                GameOver gameOver = new GameOver(this.game.getScore());
                this.controller = new GameOverController(gameOver);
                this.viewer = new GameOverViewer(gameOver);
                break;
        }
    }
}