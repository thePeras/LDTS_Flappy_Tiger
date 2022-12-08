package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.menu.Leaderboard;
import feup.ldts.flappy.view.Viewer;

import java.io.IOException;

public class LeaderboardViewer extends Viewer<Leaderboard> {

    public LeaderboardViewer(Leaderboard model) {
        super(model);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(8, 11), "Leaderboard", "#FFFFFF");
        for (int i = 0; i < getModel().getSize(); i++) {
            gui.drawText(new Position(8, 13 + i), getModel().getEntry(i), "#FC6A03");
        }
    }
}

