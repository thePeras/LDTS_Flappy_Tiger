package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.creators.FoodCreator;
import feup.ldts.flappy.model.game.creators.WallCreator;

public class ElementsFactory {
    private Game game;
    private WallCreator wallCreator;
    private FoodCreator foodCreator;

    public ElementsFactory(Game game) {
        this.game = game;
        this.wallCreator = new WallCreator();
        this.foodCreator = new FoodCreator();
    }

    public void generateCollectable(){
        game.addCollectable(foodCreator.create());
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
    }
}
