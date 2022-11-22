package feup.ldts.tanktrouble.model;

public class Color {
    private final static int MAX = 255;
    private final int r, g, b;

    private static int lighterNumber(int x){
        return MAX - ((MAX - x)/2);
    }
    private static int darkerNumber(int x){
        return x/2;
    }

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static Color darker(Color color){
        return new Color(darkerNumber(color.r), darkerNumber(color.g), darkerNumber(color.b));
    }

    public static Color lighter(Color color){
        return new Color(lighterNumber(color.r), lighterNumber(color.g), lighterNumber(color.b));
    }
}
