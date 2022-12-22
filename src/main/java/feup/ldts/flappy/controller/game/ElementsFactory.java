package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.model.game.elements.Game;
import feup.ldts.flappy.model.game.creators.CollectableCreator;
import feup.ldts.flappy.model.game.creators.WallCreator;

import java.util.Random;

public class ElementsFactory {
    private static final int GENERATE_COLLECTABLE_PROBABILITY = 60;
    private final Game game;
    private final WallCreator wallCreator;
    private final CollectableCreator collectableCreator;

    public ElementsFactory(Game game) {
        this.game = game;
        this.wallCreator = new WallCreator();
        this.collectableCreator = new CollectableCreator();
    }

    public void generateCollectable() {
        // TODO: refactor probabilities and creators classes
        int randomNum = new Random().nextInt(100);
        if (randomNum < GENERATE_COLLECTABLE_PROBABILITY) {
            game.addCollectable(collectableCreator.create());
        }
    }

    public void generateWall() {
        game.addWall(wallCreator.create());
    }

    public void step() {
        if (game.isPlaying()) {
            if (game.getSteps() == 0) generateWall();
            else if (game.getSteps() == 10) generateCollectable();
            game.incrementSteps();
        }
    }
}
