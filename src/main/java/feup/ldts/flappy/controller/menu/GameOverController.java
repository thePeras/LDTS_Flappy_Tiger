package feup.ldts.flappy.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.model.menu.GameOver;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import static feup.ldts.flappy.state.AppState.MenuState;

public class GameOverController extends Controller<GameOver> {

    public GameOverController(GameOver model) {
        super(model);
    }

    public void step(App game, KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        if (key == null) return;
        if (key.getKeyType() == KeyType.Escape) {
            game.setState(MenuState);
        }
        if (isLetter(key) || isNumber(key)) {
            getModel().addChar(key.getCharacter());
        }
        if (key.getKeyType() == KeyType.Backspace) {
            getModel().removeChar();
        }
        if (key.getKeyType() == KeyType.Enter) {
            updateLeaderboard();
            game.setState(MenuState);
        }
    }

    public void updateLeaderboard() throws IOException {
        File leaderboard = new File("src/main/resources/leaderboard.txt");
        Scanner scanner = new Scanner(leaderboard);
        String[] scores = new String[5];
        int i = 0;
        while (scanner.hasNextLine()) {
            scores[i] = scanner.nextLine();
            i++;
        }

        if (scores[4] == null) {
            FileWriter writer = new FileWriter(leaderboard, true);
            writer.write(getModel().getScore() + " - " + getModel().getName() + "\n");
            writer.close();

        } else {
            int min = Integer.parseInt(scores[0].split(" ")[0]);
            int minIndex = 0;
            for (int j = 1; j < scores.length; j++) {
                int score = Integer.parseInt(scores[j].split(" ")[0]);
                if (score < min) {
                    min = score;
                    minIndex = j;
                }
            }
            if (getModel().getScoreInt() > min) {
                scores[minIndex] = getModel().getScore() + " - " + getModel().getName();
                FileWriter writer = new FileWriter(leaderboard);
                for (String score : scores) {
                    writer.write(score + "\n");
                }
                writer.close();
            }

        }
    }


    private boolean isNumber(KeyStroke key) {
        return (key.getCharacter() >= '0' && key.getCharacter() <= '9');
    }

    private boolean isLetter(KeyStroke key) {
        return (key.getCharacter() >= 'a' && key.getCharacter() <= 'z')
                || (key.getCharacter() >= 'A' && key.getCharacter() <= 'Z');
    }
}