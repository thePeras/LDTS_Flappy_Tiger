package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.menu.Leaderboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LeaderboardViewerTest {
    private LeaderboardViewer leaderboardViewer;
    private Leaderboard leaderboard;
    private GUI gui;

    private String[] names = {"20 - Player1", " 10 - Player2", "5 - Player3", "4 - Player4", "2 - Player5"};

    @BeforeEach
    public void setUp() {
        leaderboard = new Leaderboard(names);
        leaderboardViewer = new LeaderboardViewer(leaderboard);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void testDraw() throws IOException {
        leaderboardViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(names.length+1)).drawText(Mockito.any(), Mockito.anyString(), Mockito.anyString());
    }

    @Test
    public void testDrawElements() {
        leaderboardViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(names.length+1)).drawText(Mockito.any(), Mockito.anyString(), Mockito.anyString());
    }
}
