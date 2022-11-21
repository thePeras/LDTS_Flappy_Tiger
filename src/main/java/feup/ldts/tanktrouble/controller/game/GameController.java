package feup.ldts.tanktrouble.controller.game;

import feup.ldts.tanktrouble.controller.Controller;
import feup.ldts.tanktrouble.model.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
