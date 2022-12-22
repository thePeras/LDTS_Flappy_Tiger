package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.Colors;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawRectangle(wall.getPosition(), wall.getWidth(), wall.getHeight(), Colors.GREEN.getHex());
        int newY = wall.getHeight() + wall.getSpace();
        gui.drawRectangle(new Position(wall.getPosition().getX(), newY), wall.getWidth(), gui.getHeight() - (wall.getHeight() + wall.getSpace()), Colors.GREEN.getHex());
    }
}
