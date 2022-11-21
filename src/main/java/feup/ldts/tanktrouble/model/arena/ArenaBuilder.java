package feup.ldts.tanktrouble.model.arena;

import feup.ldts.tanktrouble.model.elements.Tank;
import feup.ldts.tanktrouble.model.elements.Wall;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setTank(createTank());
        arena.setWalls(createWalls());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();
    protected abstract Tank createTank();

}
