package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall element, GUI gui) {
        drawWall(element.getPosition().getX(), element.getHeight(), element.getSpace(), gui);
    }

    private void drawWall(int x, int height, int space, GUI gui) {
        for (int y = 0; y < height; y++) {
            gui.drawPixel(x, y, '#', "#FF0000");
            gui.drawPixel(x+1, y, '#', "#FF0000");
        }
        for (int y = height + space; y < gui.getHeight(); y++) {
            gui.drawPixel(x, y, '#', "#FF0000");
            gui.drawPixel(x+1, y, '#', "#FF0000");
        }
    }
}
