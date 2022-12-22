package feup.ldts.flappy.model.menu;

import feup.ldts.flappy.controller.SoundManager;
import feup.ldts.flappy.model.sound.SoundEffects;

import java.util.List;

public abstract class Menu {
    protected List<String> options;
    protected int option = 0;

    public int getNumberEntries() {
        return this.options.size();
    }

    public String getEntry(int i) {
        return this.options.get(i);
    }

    public void nextOption() {
        SoundManager.getInstance().playSoundEffect(SoundEffects.MENU_SELECT);
        option++;
        if (option > this.options.size() - 1)
            option = 0;
    }

    public void previousOption() {
        SoundManager.getInstance().playSoundEffect(SoundEffects.MENU_SELECT);
        option--;
        if (option < 0)
            option = this.options.size() - 1;
    }

    public boolean isSelected(int i) {
        return option == i;
    }
}
