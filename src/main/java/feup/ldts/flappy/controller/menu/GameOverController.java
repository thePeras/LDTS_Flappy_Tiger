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
import java.util.ArrayList;
import java.util.Collections;
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
        if (isLetter(key) || isNumber(key) || isSpace(key)) {
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
        File leaderboard = new File("src/main/resources/text/leaderboard.txt");
        Scanner scanner = new Scanner(leaderboard);
        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<String> usernames = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("-");
            scores.add(Integer.parseInt(parts[0].trim()));
            usernames.add(parts[1].trim());
        }

        if(scores.size() < 5){
            FileWriter writer = new FileWriter(leaderboard, true);
            writer.write(getModel().getScore() + " - " + getModel().getUsername() + "\n");
            writer.close();
            return;
        }

        int minimumScore = Collections.min(scores);
        int minimumScoreIndex = scores.indexOf(minimumScore);

        if(getModel().getScore() > minimumScore){
            scores.set(minimumScoreIndex, getModel().getScore());
            usernames.set(minimumScoreIndex, getModel().getUsername());
            FileWriter writer = new FileWriter(leaderboard);
            for(int i = 0; i < scores.size(); i++){
                writer.write(scores.get(i) + " - " + usernames.get(i) + "\n");
            }
            writer.close();
        }
    }

    private boolean isNumber(KeyStroke key) {
        return (key.getCharacter() >= '0' && key.getCharacter() <= '9');
    }

    private boolean isLetter(KeyStroke key) {
        return (key.getCharacter() >= 'a' && key.getCharacter() <= 'z')
                || (key.getCharacter() >= 'A' && key.getCharacter() <= 'Z');
    }

    private boolean isSpace(KeyStroke key) {
        return key.getCharacter() == ' ';
    }
}