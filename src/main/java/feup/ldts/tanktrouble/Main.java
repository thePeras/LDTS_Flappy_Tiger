package feup.ldts.tanktrouble;

import feup.ldts.tanktrouble.gui.LanternaGUI;
import feup.ldts.tanktrouble.states.MenuState;
import feup.ldts.tanktrouble.model.Menu;
import feup.ldts.tanktrouble.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    private final LanternaGUI gui;
    private State state;

    public Main() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(20, 20);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Main().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

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
