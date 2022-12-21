package feup.ldts.flappy.model.game.creators;

import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.collectables.Boar;
import feup.ldts.flappy.model.game.collectables.Collectable;
import feup.ldts.flappy.model.game.collectables.Lamb;
import feup.ldts.flappy.model.game.collectables.PortoWine;

import java.util.Random;

public class CollectableCreator extends Creator<Collectable> {
    private final static int margin = 5;
    private final static int lambProbability = 20;
    private final static int portoWineProbability = 10;
    private final Random random;
    public CollectableCreator() {
        this.random = new Random();
    }

    @Override
    public Collectable create() {
        int randomY = random.nextInt(LanternaGUI.height - 2*margin) + margin;
        Position randomPosition = new Position(LanternaGUI.width, randomY);

        int randomType = random.nextInt(100);

        if(randomType < portoWineProbability) {
            return new PortoWine(randomPosition);
        }
        if(randomType < lambProbability + portoWineProbability) {
            return new Lamb(randomPosition);
        }
        else {
            return new Boar(randomPosition);
        }
    }
}
