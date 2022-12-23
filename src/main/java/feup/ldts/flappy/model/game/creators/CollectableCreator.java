package feup.ldts.flappy.model.game.creators;

import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.model.game.collectables.Boar;
import feup.ldts.flappy.model.game.collectables.Collectable;
import feup.ldts.flappy.model.game.collectables.Lamb;
import feup.ldts.flappy.model.game.collectables.PortoWine;

import java.util.Random;

public class CollectableCreator extends Creator<Collectable> {
    private final static int MARGIN = 5;
    private final double portoWineProbability;

    private final double lambProbability;

    private final Random random;

    public CollectableCreator() {
        this.random = new Random();
        this.portoWineProbability = 0.15;
        this.lambProbability = (1 - portoWineProbability) * 0.4;
    }

    @Override
    public Collectable create() {
        int randomY = random.nextInt(LanternaGUI.HEIGHT - 2 * MARGIN) + MARGIN;
        Position randomPosition = new Position(LanternaGUI.WIDTH, randomY);

        double randomCollectableType = random.nextDouble();

        if (randomCollectableType < portoWineProbability) {
            return new PortoWine(randomPosition);
        }
        if (randomCollectableType < lambProbability + portoWineProbability) {
            return new Lamb(randomPosition);
        } else {
            return new Boar(randomPosition);
        }
    }
}
