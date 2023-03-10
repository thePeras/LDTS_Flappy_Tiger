package feup.ldts.flappy.model.game.elements;

import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Position;

import java.util.ArrayList;
import java.util.List;

public class Ground extends Element implements Collidable {

    public Ground(int y) {
        super(new Position(0, y));
    }

    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < LanternaGUI.WIDTH; i++) {
            positions.add(new Position(i, this.getPosition().getY()));
        }
        return positions;
    }
}
