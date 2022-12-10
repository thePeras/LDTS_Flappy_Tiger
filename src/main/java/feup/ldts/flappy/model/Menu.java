package feup.ldts.flappy.model;

import java.util.List;

public class Menu {
    protected List<String> options;
    protected int option = 0;

    public int getNumberEntries() {
        return this.options.size();
    }

    public String getEntry(int i) {
        return this.options.get(i);
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
}
