package feup.ldts.tanktrouble.states;

import feup.ldts.tanktrouble.controller.Controller;
import feup.ldts.tanktrouble.controller.game.ArenaController;
import feup.ldts.tanktrouble.model.arena.Arena;
import feup.ldts.tanktrouble.viewer.GameViewer;
import feup.ldts.tanktrouble.viewer.Viewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
