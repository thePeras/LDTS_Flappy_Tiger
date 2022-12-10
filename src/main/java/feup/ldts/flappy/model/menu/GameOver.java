package feup.ldts.flappy.model.menu;

public class GameOver {
    private static final int LIMITCHAR = 11;
    String[] scores = new String[5];
    private String nickNameSpaces;
    private String username;
    private Integer score;


    public GameOver(int score) {
        this.username = "";
        this.score = score;
    }

    public String getName() {
        return username;
    }


    public void addChar(Character character) {
        username += character;
    }

    public void removeChar() {
        if (username.length() > 0) {
            username = username.substring(0, username.length() - 1);
        }
    }

    public String getScore() {
        return score.toString();
    }

    public int getScoreInt() {
        return score;

    }
}