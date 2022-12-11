package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.creators.CollectableCreator;
import feup.ldts.flappy.model.game.creators.WallCreator;

public class ElementsFactory {
    private final Game game;
    private final WallCreator wallCreator;
    private final CollectableCreator collectableCreator;

    public ElementsFactory(Game game) {
        this.game = game;
        this.wallCreator = new WallCreator();
        this.collectableCreator = new CollectableCreator();
    }

    public void generateCollectable(){
        game.addCollectable(collectableCreator.create());
    }

    public void generateWall(){
        game.addWall(wallCreator.create());
    }

    public void step() {
        if(game.isPlaying()) {
            if(game.getSteps() == 0) generateWall();
            else if(game.getSteps() == 10) generateCollectable();
            game.incrementSteps();
        }
        game.getWalls().removeIf(wall -> wall.getPosition().getX() < -1);
        game.getCollectables().removeIf(collectable -> collectable.getPosition().getX() < 0);
    }
}
