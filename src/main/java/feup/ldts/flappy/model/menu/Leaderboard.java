package feup.ldts.flappy.model.menu;

public class Leaderboard extends Menu {
    //Vector that stores the top 10 scores and the names of the players
    private final String[] top5;

    public Leaderboard(String[] top10) {
        this.top5 = top10;
    }

    public String[] getTop5() {
        return top5;
    }

    public int getSize(){
        return top5.length;
    }

    public String getEntry(int i){
        return top5[i];
    }
}
