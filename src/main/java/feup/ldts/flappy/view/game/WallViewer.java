package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Colors;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.Wall;

public class WallViewer implements ElementViewer<Wall> {
    //TODO: use drawRectangle here
    @Override
    public void draw(Wall wall, GUI gui) {
        int x = wall.getPosition().getX();
        for (int y = 0; y <= gui.getHeight(); y++) {
            if (wall.isGapHeight(y)) continue;
            gui.paintPixel(new Position(x, y), Colors.GREEN.getHex());
            gui.paintPixel(new Position(x+1, y), Colors.GREEN.getHex());
        }
    }
}
