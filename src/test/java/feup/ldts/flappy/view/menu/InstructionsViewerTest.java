package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.menu.Instructions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class InstructionsViewerTest {
    private InstructionsViewer instructionsViewer;
    private Instructions instructions;
    private GUI gui;

    @BeforeEach
    public void setUp() {
        instructions = new Instructions();
        instructionsViewer = new InstructionsViewer(instructions);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void testDraw() {
        instructionsViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(instructions.getInstructions().length + 1)).drawText(Mockito.any(), Mockito.anyString(), Mockito.anyString());
    }

    @Test
    public void testDrawElements() {
        instructionsViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(instructions.getInstructions().length + 1)).drawText(Mockito.any(), Mockito.anyString(), Mockito.anyString());
    }
}
