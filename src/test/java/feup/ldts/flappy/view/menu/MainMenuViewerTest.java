package feup.ldts.flappy.view.menu;


import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MainMenuViewerTest {
    private MenuViewer menuViewer;
    private MainMenu mainMenu;
    private GUI gui;

    @BeforeEach
    public void setUp() {
        mainMenu = new MainMenu();
        menuViewer = new MenuViewer(mainMenu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void testDraw() throws IOException {
        menuViewer.draw(gui);
        int numberOfEntries = mainMenu.getNumberEntries() + 1;
        Mockito.verify(gui, Mockito.times(numberOfEntries)).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
    }

    @Test
    public void testDrawElements() {
        menuViewer.drawElements(gui);
        int numberOfEntries = mainMenu.getNumberEntries() + 1;
        Mockito.verify(gui, Mockito.times(numberOfEntries)).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
    }
}
