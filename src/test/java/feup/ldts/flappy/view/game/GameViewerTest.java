package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Position;
import feup.ldts.flappy.model.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameViewerTest {
    private GameViewer viewer;
    private Game game;
    private GUI gui;

    @BeforeEach
    public void setUp() {
        game = new Game();
        viewer = new GameViewer(game);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void testDraw() {
        viewer.drawElements(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayer(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
