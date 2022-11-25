package feup.ldts.flappy.model.menu;

public class Leaderboard extends Menu {
        //Vector that stores the top 10 scores and the names of the players
        private String[] top10;

    public Leaderboard(String[] top10) {
            this.top10 = top10;
        }

        public String[] getTop10() {
        return top10;
    }

}
