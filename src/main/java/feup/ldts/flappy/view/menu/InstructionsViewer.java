package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.Instructions;
import feup.ldts.flappy.view.Viewer;

import java.io.IOException;

public class InstructionsViewer extends Viewer<Instructions> {

        public InstructionsViewer(Instructions model) {
            super(model);
        }
    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

        @Override
        public void drawElements(GUI gui) {
            //Draw instructions
            gui.drawText(new Position (2, 5), "Instructions", "#FFFFFF");
            for (int i = 0; i < getModel().getNumberEntries(); i++) {
                gui.drawText(new Position(2, 7 + i), getModel().getEntry(i),"#FC6A03");
            }
        }
}
