package feup.ldts.flappy.controller.game;

import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.creators.FoodCreator;
import feup.ldts.flappy.model.game.creators.WallCreator;

public class ElementsFactory {
    private Game game;
    private WallCreator wallCreator;
    private FoodCreator foodCreator;
    private int steps;

    public ElementsFactory(Game game) {
        this.game = game;
        this.steps = 0;
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
            if(steps == 20) steps = 0;
            if(steps == 0) generateWall();
            else if(steps == 10) generateCollectable();

            steps++;
        }
    }
}
