package feup.ldts.flappy.model.game.creators;

import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.collectables.Food;

import java.util.Random;

public class FoodCreator extends Creator<Food> {
    private final static int margin = 5;
    private Random random;

    public FoodCreator() {
        this.random = new Random();
    }

    @Override
    public Food create() {
        int randomY = random.nextInt(LanternaGUI.height - 2*margin) + margin;
        Position randomPosition = new Position(LanternaGUI.width, randomY);
        //TODO: add type of food (deer or bear)
        return new Food(randomPosition, 5);
    }
}
