package feup.ldts.flappy.model.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Leaderboard {
    //Vector that stores the top 5 scores and the names of the players
    private final String[] top5 = new String[5];

    public Leaderboard(File leaderboardFile) throws FileNotFoundException {
        fillLeaderboard(leaderboardFile);
    }

    private void fillLeaderboard(File leaderboardFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(leaderboardFile);
        for (int i = 0; i < 5; i++) {
            top5[i] = scanner.nextLine();
        }
        sortLeaderboard();
    }

    private void sortLeaderboard() {
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (Integer.parseInt(top5[i].split(" ")[0]) < Integer.parseInt(top5[j].split(" ")[0])) {
                    String aux = top5[i];
                    top5[i] = top5[j];
                    top5[j] = aux;
                }
            }
        }
    }

    public int getSize() {
        return top5.length;
    }

    public String getEntry(int i) {
        return top5[i];
    }
}
