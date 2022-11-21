package feup.ldts.tanktrouble.model;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int option = 0;

    public Menu() {
        this.entries = Arrays.asList("Start", "Exit");
    }

    public void nextOption() {
        this.option = (option + 1) % entries.size();
    }

    public void previousOption() {
        this.option = (option - 1) % entries.size();
    }

    public String getEntry(int i) {
        return entries.get(i);
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
        return this.entries.size();
    }
}
