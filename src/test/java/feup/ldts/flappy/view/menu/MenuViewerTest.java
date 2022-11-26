package feup.ldts.flappy.view.menu;


import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Position;
import feup.ldts.flappy.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuViewerTest {
    private MenuViewer menuViewer;
    private Menu menu;
    private GUI gui;

    @BeforeEach
    public void setUp() {
        menu = new Menu();
        menuViewer = new MenuViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void testDraw() throws IOException {
        menuViewer.draw(gui);
        int numberOfEntries = menu.getNumberEntries() + 1;
        Mockito.verify(gui, Mockito.times(numberOfEntries)).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
    }

    @Test
    public void testDrawElements() {
        menuViewer.drawElements(gui);
        int numberOfEntries = menu.getNumberEntries() + 1;
        Mockito.verify(gui, Mockito.times(numberOfEntries)).drawText(Mockito.any(Position.class), Mockito.anyString(), Mockito.anyString());
    }
}
