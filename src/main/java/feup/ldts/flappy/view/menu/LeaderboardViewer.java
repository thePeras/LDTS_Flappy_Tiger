package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Position;
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
        gui.drawText(new Position(2, 7), ">" + getModel().getTop10()[0], "#FFD700");
    }
}

