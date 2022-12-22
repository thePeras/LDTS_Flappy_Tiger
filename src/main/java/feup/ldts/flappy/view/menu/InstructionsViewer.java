package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Colors;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.Instructions;

public class InstructionsViewer extends MenuViewer<Instructions> {

    public InstructionsViewer(Instructions model) {
        super(model, new Position(2, 7));
    }

    public void drawInsideElements(GUI gui) {
        drawTitle(gui, "Instructions", Colors.WHITE.getHex());

        for (int i = 0; i < getModel().getSize(); i++) {
            drawText(gui, new Position(2, 7 + i), getModel().getLine(i), Colors.ORANGE.getHex());
        }
    }

    @Override
    public void drawOptions(GUI gui) {

    }
}
