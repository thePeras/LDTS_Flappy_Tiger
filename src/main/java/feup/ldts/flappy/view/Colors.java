package feup.ldts.flappy.view;

public enum Colors {
    ORANGE("#FC6A03"),
    BLUE("#8ECAE6"),
    DARK_BLUE("#08001f"),
    GREEN("#6b9e06"),
    DARK_GREEN("#3B5110"),
    WHITE("#e8e8e8"),
    MENU_BACKGROUND("#101010"),
    BROWN("#624226"),
    GREY("#969696");

    private final String hex;

    Colors(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }
}
