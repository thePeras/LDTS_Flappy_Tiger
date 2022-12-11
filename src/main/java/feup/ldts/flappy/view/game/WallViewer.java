package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        int x = wall.getPosition().getX();
        for (int y = 0; y <= gui.getHeight(); y++) {
            if (wall.isGapHeight(y)) continue;
            gui.drawPixel(new Position(x, y), '#', "#FF0000");
            gui.drawPixel(new Position(x+1, y), '#', "#FF0000");
        }
    }
}
