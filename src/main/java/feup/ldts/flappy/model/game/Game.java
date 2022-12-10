package feup.ldts.flappy.model.game;

import feup.ldts.flappy.gui.LanternaGUI;
import feup.ldts.flappy.model.game.collectables.Collectable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {
    private boolean isPlaying;
    private boolean isInGameMode;
    private List<Wall> wallsList;
    private List<Collectable> collectablesList;
    private final Player player;

    private int score;
    public static int distanceBetweenWalls = 20;

    public Game() {
        this.isPlaying = false;
        this.isInGameMode = false;
        this.player = new Player(new Position(9, LanternaGUI.height / 2 - 1));
        this.wallsList = new ArrayList<>();
        this.collectablesList = new ArrayList<>();
        this.score = 0;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
    public void setPlaying(boolean playing){this.isPlaying = playing; }

    public void startPlaying() {
        isPlaying = true;
    }

    public List<Wall> getWalls(){
        return wallsList;
    }
    public void addWall(Wall wall){ wallsList.add(wall);}
    public void removeWall(Iterator<Wall> iterator){ iterator.remove();}

    public List<Collectable> getCollectables(){
        return collectablesList;
    }
    public void addCollectable(Collectable collectable){ collectablesList.add(collectable);}
    public void removeCollectable(Iterator<Collectable> collectable){ collectable.remove();}

    public void incrementScore(){ score++; }

    public int getScore(){ return score; }
}
