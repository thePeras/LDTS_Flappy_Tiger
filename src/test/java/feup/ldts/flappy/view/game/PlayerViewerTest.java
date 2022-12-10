package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Player;
import feup.ldts.flappy.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class PlayerViewerTest {

    private Player player;
    private PlayerViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        player = new Player(new Position(10, 10));
        viewer = new PlayerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void testDraw() {
        viewer.draw(player, gui);
        Mockito.verify(viewer, Mockito.times(1)).drawPlayer(player.getPosition(), gui);
    }
}
