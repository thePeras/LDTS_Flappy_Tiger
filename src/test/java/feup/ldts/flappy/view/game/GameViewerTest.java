package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameViewerTest {
    private GameViewer viewer;

    private PlayerViewer playerViewer;

    private Game game;
    private GUI gui;

    @BeforeEach
    public void setUp() {
        game = new Game();
        viewer = new GameViewer(game);
        gui = Mockito.mock(GUI.class);
        playerViewer = Mockito.mock(PlayerViewer.class);
    }

    @Test
    public void testDraw() {
        viewer.drawElements(gui);

        Mockito.verify(playerViewer, Mockito.times(1)).drawPlayer(Mockito.any(Position.class), gui);
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
