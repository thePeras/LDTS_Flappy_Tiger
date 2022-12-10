package feup.ldts.flappy.model.game;

import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.collectables.Collectable;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static int distanceBetweenWalls = 20;
    private final Player player;
    private final Wall wall1, wall2;
    private boolean isPlaying;
    private boolean isInGameMode;
    private List<Collectable> collectablesList;
    private int score = 12;

    public Game() {
        this.isPlaying = false;
        this.isInGameMode = false;
        this.player = new Player(new Position(9, LanternaGUI.height / 2 - 1));
        this.wall1 = new Wall(LanternaGUI.width);
        this.wall2 = new Wall(LanternaGUI.width + distanceBetweenWalls);
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

    public Wall getWall1() {
        return wall1;
    }

    public Wall getWall2() {
        return wall2;
    }

    public List<Wall> getWalls() {
        return List.of(wall1, wall2);
    }

    public List<Collectable> getCollectables() {
        return new ArrayList<>();
    }

    public void removeCollectable(Collectable collectable) {
        collectablesList.remove(collectable);
    }

    public int getScore() {
        return score;
    }
}

