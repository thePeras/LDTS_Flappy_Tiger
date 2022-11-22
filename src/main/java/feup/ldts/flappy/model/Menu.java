package feup.ldts.flappy.model;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> options;
    private int option = 0;

    public Menu() {
        this.options = Arrays.asList("Start", "Exit");
    }

    public void nextOption() {
        option++;
        if (option > this.options.size() - 1)
            option = 0;
    }

    public void previousOption(){
        option--;
        if (option < 0)
            option = this.options.size() - 1;
    }

    public boolean isSelected(int i) {
        return option == i;
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.options.size();
    }
}
