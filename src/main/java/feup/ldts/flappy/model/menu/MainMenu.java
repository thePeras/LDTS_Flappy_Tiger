package feup.ldts.flappy.model.menu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;

public class MainMenu extends Menu {
    String curiosity;

    public MainMenu() throws IOException {
        fillCuriosity();
        this.options = Arrays.asList("Start", "Leaderboard", "Instructions", "Exit");
    }

    private void fillCuriosity() throws IOException {
        Path path_ = Path.of("src/main/resources/text/curiosities.txt");
        String contents = Files.readString(path_);
        String[] curiosities = contents.split("###");
        Random random = new Random();
        int randomValue = random.nextInt(curiosities.length);
        this.curiosity = curiosities[randomValue];
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
