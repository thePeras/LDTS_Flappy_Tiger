package feup.ldts.tanktrouble.viewer;

import feup.ldts.tanktrouble.gui.GUI;
import feup.ldts.tanktrouble.model.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
