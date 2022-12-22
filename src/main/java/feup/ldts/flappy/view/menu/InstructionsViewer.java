package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Colors;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.Instructions;
import feup.ldts.flappy.view.Viewer;

public class InstructionsViewer extends Viewer<Instructions> {

    public InstructionsViewer(Instructions model) {
        super(model);
    }

    public void drawElements(GUI gui) {
        gui.paintBackground(Colors.MENU_BACKGROUND.getHex());

        gui.drawMenuText(new Position(2, 5), "Instructions", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawMenuText(new Position(2, 7 + i), getModel().getEntry(i), "#FC6A03");
        }
    }
}
