package feup.ldts.flappy.controller.menu;

import feup.ldts.flappy.App;

import java.io.IOException;

public interface MenuInterface {
    void optionSelected(App game) throws IOException;
    void escapePressed(App game) throws IOException;
    void backspacePressed(App game) throws IOException;
}
