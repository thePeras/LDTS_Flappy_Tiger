package feup.ldts.flappy.model.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Leaderboard {
    private final ArrayList<String> top5players = new ArrayList<>();

    public Leaderboard() throws FileNotFoundException {
        File leaderboardFile = new File("src/main/resources/text/leaderboard.txt");
        fillLeaderboard(leaderboardFile);
    }

    private void fillLeaderboard(File leaderboardFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(leaderboardFile);
        while (scanner.hasNextLine()) {
            top5players.add(scanner.nextLine());
        }
        sortLeaderboard();
    }

    private void sortLeaderboard() {
        top5players.sort((s1, s2) -> {
            String[] s1Split = s1.split(" ");
            String[] s2Split = s2.split(" ");
            return Integer.parseInt(s2Split[0]) - Integer.parseInt(s1Split[0]);
        });
    }

    public int getSize() {
        return top5players.size();
    }

    public String getEntry(int i) {
        return top5players.get(i);
    }
}
