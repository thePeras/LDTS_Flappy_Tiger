package feup.ldts.flappy.model;

public enum Colors {
    ORANGE("#FC6A03"),
    BLUE("#8ECAE6"),
    GREEN("#3B5110"),
    WHITE("#FFFFFF"),
    MENU_BACKGROUND("#1f1f1f"),
    BROWN("#624226"),
    GREY("#969696")
    ;

    private final String hex;

    Colors(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }
}
