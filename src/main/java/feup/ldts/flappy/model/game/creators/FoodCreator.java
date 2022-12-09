package feup.ldts.flappy.model.game.creators;

import feup.ldts.flappy.model.game.Element;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.collectables.Food;

import java.util.Random;

public class FoodCreator extends Creator {
    private final static int margin = 5;
    private Random random;

    public FoodCreator() {
        this.random = new Random();
    }

    @Override
    public Element create() {
        int randomY = random.nextInt(35 - 2*margin) + margin;
        Position randomPosition = new Position(30, randomY);

        return new Food(randomPosition, 5);
    }
}
