package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.elements.Wall;
import feup.ldts.flappy.view.Colors;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawRectangle(wall.getPosition(), Wall.getWidth(), wall.getHeight(), Colors.GREEN.getHex());
        int newY = wall.getHeight() + wall.getSpace();
        gui.drawRectangle(new Position(wall.getPosition().getX(), newY), Wall.getWidth(), gui.getHeight() - (wall.getHeight() + wall.getSpace()), Colors.GREEN.getHex());
    }
}
