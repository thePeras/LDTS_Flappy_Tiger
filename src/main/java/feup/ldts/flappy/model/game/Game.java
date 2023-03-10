package feup.ldts.flappy.model.game;

import feup.ldts.flappy.controller.sound.SoundEffects;
import feup.ldts.flappy.controller.sound.SoundManager;
import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.collectables.Collectable;
import feup.ldts.flappy.model.game.elements.Ground;
import feup.ldts.flappy.model.game.elements.Player;
import feup.ldts.flappy.model.game.elements.Wall;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int GOD_MODE_MAX_STEPS = 100;
    private static final int GOD_MODE_WALL_SPACE = 28;
    private final Player player;
    private final List<Wall> wallsList;
    private final List<Collectable> collectablesList;
    private boolean isPlaying;
    private boolean isInGodMode;
    private final Ground ground;
    private int score;
    private int steps;
    private int godModeSteps = 0;

    public Game() {
        this.isPlaying = false;
        this.isInGodMode = false;
        this.player = new Player(new Position(9, LanternaGUI.HEIGHT / 2 - 1));
        this.wallsList = new ArrayList<>();
        this.collectablesList = new ArrayList<>();
        this.score = 0;
        this.steps = 0;
        this.ground = new Ground(LanternaGUI.HEIGHT);
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        this.isPlaying = playing;
    }

    public void startPlaying() {
        isPlaying = true;
    }

    public List<Wall> getWalls() {
        return wallsList;
    }

    public void addWall(Wall wall) {
        wallsList.add(wall);
    }

    public List<Collectable> getCollectables() {
        return collectablesList;
    }

    public void addCollectable(Collectable collectable) {
        collectablesList.add(collectable);
    }

    public void consumeCollectable(Collectable collectable) {
        SoundManager.getInstance().playSoundEffect(SoundEffects.CONSUME);
        collectable.consume(this);
    }

    public void incrementScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return steps;
    }

    public Ground getGround() {
        return ground;
    }

    private void updateWalls() {
        for (Wall wall : wallsList) {
            if (wall.getPosition().getX() > player.getPosition().getX()) {
                wall.setSpace(GOD_MODE_WALL_SPACE);
            }
        }
    }

    public void incrementSteps() {
        steps++;
        if (steps == 20) steps = 0;

        if (isInGodMode) {
            godModeSteps++;
            updateWalls();
            if (godModeSteps == GOD_MODE_MAX_STEPS) {
                isInGodMode = false;
                SoundManager.getInstance().stopGodModeSound();
            }
        }
    }

    public void startGodMode() {
        isInGodMode = true;
        godModeSteps = 0;
        updateWalls();
        SoundManager.getInstance().playGodModeSound();
    }
}
