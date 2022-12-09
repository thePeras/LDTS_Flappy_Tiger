package feup.ldts.flappy.model.menu;

import java.util.ArrayList;
import java.util.List;

public class GameOver {
    private String nickNameSpaces;
    private String nickName;
    private static final int LIMITCHAR = 11;
    private Integer newScore;
    List<Integer> score;
    List<String> name;
    public GameOver() {
        this.nickNameSpaces = "_ _ _ _ _ _ _ _ _ _ _";
        this.nickName = "";
        this.newScore = 5;
        this.score = new ArrayList<>();
        this.name = new ArrayList<>();
    }

    public String getNickName() {
        return nickName;
    }

    public String getNickNameSpaces() {
        return nickNameSpaces;
    }



    public List<Integer> getScore() {
        return score;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public void setScoreList(List<Integer> score) {
        this.score = score;
    }
}