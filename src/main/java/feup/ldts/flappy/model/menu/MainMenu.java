package feup.ldts.flappy.model.menu;

import feup.ldts.flappy.model.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainMenu extends Menu {

    String curiosity;
    public MainMenu(String[] curiosities) {
        Random random = new Random();
        int randomValue = random.nextInt(curiosities.length);
        this.curiosity = curiosities[randomValue];
        this.options = Arrays.asList("Start", "Leaderboard", "Instructions", "Exit");
    }

    public boolean isSelectedExit() {
        return isSelected(3);
    }
    public boolean isSelectedInstructions() {
        return isSelected(2);
    }
    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedLeaderboard() {
        return isSelected(1);
    }

    public String getCuriosity() {
        return curiosity;
    }




}
