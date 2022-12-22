package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Colors;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.Pause;

public class PauseViewer extends MenuViewer<Pause> {

    public PauseViewer(Pause model) {
        super(model, new Position(8, 13));
    }

    @Override
    protected void drawInsideElements(GUI gui) {
        drawTitle(gui, "Pause", Colors.ORANGE.getHex());
    }
}
