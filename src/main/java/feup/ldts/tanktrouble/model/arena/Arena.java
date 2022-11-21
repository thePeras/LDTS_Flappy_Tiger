package feup.ldts.tanktrouble.model.arena;

import feup.ldts.tanktrouble.model.Position;
import feup.ldts.tanktrouble.model.elements.Tank;
import feup.ldts.tanktrouble.model.elements.Wall;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Tank tank; //TODO: More than one tank

    private List<Wall> walls;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }
}
