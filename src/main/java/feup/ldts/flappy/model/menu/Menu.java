package feup.ldts.flappy.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> options;
    private int option = 0;

    public Menu() {
        this.options = Arrays.asList("Start", "Leaderboard", "Instructions", "Exit");
    }

    public void nextOption() {
        option++;
        if (option > this.options.size() - 1)
            option = 0;
    }

    public void previousOption() {
        option--;
        if (option < 0)
            option = this.options.size() - 1;
    }

    public boolean isSelected(int i) {
        return option == i;
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

    public int getNumberEntries() {
        return this.options.size();
    }

    public String getEntry(int i) {
        return this.options.get(i);
    }


}
