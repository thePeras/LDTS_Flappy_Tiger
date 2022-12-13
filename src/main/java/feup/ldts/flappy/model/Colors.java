package feup.ldts.flappy.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Colors {
    ORANGE("#FC6A03"),
    BLUE("#8ECAE6"),
    GREEN("#3B5110"),
    WHITE("#FFFFFF"),
    MENU_BACKGROUND("#101010"),
    BROWN("#624226"),
    GREY("#969696");

    private final String hex;
    private int lastPlayerColor;

    Colors(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }
}
