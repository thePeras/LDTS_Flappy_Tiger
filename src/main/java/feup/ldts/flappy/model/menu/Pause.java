package feup.ldts.flappy.model.menu;

import java.util.Arrays;

public class Pause extends Menu {

    public Pause() {
        super();
        this.options = Arrays.asList("Resume", "Restart", "Main Menu");
    }

    public boolean isSelected(int i) {
        return option == i;
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
    public boolean isSelectedResume() {
        return isSelected(0);
    }
    public boolean isSelectedRestart() {
        return isSelected(1);
    }

}




