package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Colors;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.Leaderboard;

public class LeaderboardViewer extends MenuViewer<Leaderboard> {

    public LeaderboardViewer(Leaderboard model) {
        super(model, new Position(8, 13));
    }

    protected void drawInsideElements(GUI gui) {
        drawTitle(gui, "Leaderboard", Colors.WHITE.getHex());

        for (int i = 0; i < getModel().getSize(); i++) {
            drawText(gui, new Position(8, 13 + i), getModel().getLine(i), Colors.ORANGE.getHex());
        }
    }

    @Override
    public void drawOptions(GUI gui) {

    }
}

