package feup.ldts.flappy.model.menu;

import java.io.FileNotFoundException;

public class Instructions extends TextMenu {
    public Instructions() throws FileNotFoundException {
        super("src/main/resources/text/instructions.txt");
    }
}
