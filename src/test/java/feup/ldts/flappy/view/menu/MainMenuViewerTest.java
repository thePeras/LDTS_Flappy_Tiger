package feup.ldts.flappy.view.menu;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.menu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MainMenuViewerTest {
    private MainMenuViewer menuViewer;
    private MainMenu mainMenu;
    private GUI gui;

    @BeforeEach
void setUp() throws IOException {
        mainMenu = new MainMenu();
        menuViewer = new MainMenuViewer(mainMenu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void testDraw() throws IOException {
        menuViewer.draw(gui);
        int numberOfEntries = mainMenu.getNumberEntries() + 1;
        //Mockito.verify(gui, Mockito.times(numberOfEntries)).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
    }

    @Test
    public void testDrawElements() {
        menuViewer.drawElements(gui);
        int numberOfEntries = mainMenu.getNumberEntries() + 1;
        //Mockito.verify(gui, Mockito.times(numberOfEntries)).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
    }
}
