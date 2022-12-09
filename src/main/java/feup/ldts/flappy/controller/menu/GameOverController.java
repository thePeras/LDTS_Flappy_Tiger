package feup.ldts.flappy.controller.menu;

import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.menu.GameOver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.Scanner;

import static feup.ldts.flappy.state.AppState.MenuState;

public class GameOverController extends Controller {

    public GameOverController(GameOver model) {
        super(model);
    }

    public void step(App game, GUI.ACTION action) throws IOException, URISyntaxException, FontFormatException {
        if (Objects.requireNonNull(action) == GUI.ACTION.ESCAPE) {
            game.setState(MenuState);
        }
    }
}
   /**     boolean isNumber = getKeyCode() >= KeyEvent.VK_0 && e.getKeyCode() <= KeyEvent.VK_9;
        boolean isLetterMin = e.getKeyCode() > 96 && e.getKeyCode() < 123;
        boolean isCapitalLetter = e.getKeyCode() >= KeyEvent.VK_A && e.getKeyCode() <= KeyEvent.VK_Z;
    }
    public void keyPressed(KeyEvent e) {
        boolean isNumber = e.getKeyCode() >= KeyEvent.VK_0 && e.getKeyCode() <= KeyEvent.VK_9;
        boolean isLetterMin = e.getKeyCode() > 96 && e.getKeyCode() < 123;
        boolean isCapitalLetter = e.getKeyCode() >= KeyEvent.VK_A && e.getKeyCode() <= KeyEvent.VK_Z;

        if (isLetterMin || isCapitalLetter || isNumber)
            if(KeyEvent.getKeyText(e.getKeyCode()).length() == 1)
                writeName(e.getKeyChar());

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            updateLeaderboard(Constants.LEADERBOARD_FILE);
            nextState();
        }
    }

    public void updateLeaderboard(String path) {
        int line = 0;
        int newRank = 0;

        try {
            File myObj = new File(Constants.ROOT+path);
            Scanner myReader = new Scanner(myObj, Charset.defaultCharset().name());
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                line++;
                if(line >= 3 && line <= 12){  //lines of leaderboardDraw.txt with the score
                    Integer lineScore = Integer.parseInt(data.substring(26,31));
                    score.add(lineScore);
                    if(newScore <= lineScore)
                        newRank = line - 1;
                    name.add(data.substring(8,26));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error:" + e.getMessage());
        }
        addToLeaderBoard(newRank);
        writeLeaderboard(path);
    }

    private void addToLeaderBoard(int newRank){
        if(newRank > 0 && newRank <= 10) { // se ficar nos 10 melhores
            score.add(newRank-1, newScore);
            name.add(newRank-1,nickName + " ".repeat(Math.max(0, 18 - nickName.length())));
            score.remove(10);
            name.remove(10);
        }
    }
    public void writeLeaderboard(String path) {
        try {
            FileWriter myWriter = new FileWriter(Constants.ROOT+path, Charset.defaultCharset());
            myWriter.write("======L E A D E R B O A R D=======\n");
            myWriter.write("||                              ||\n");

            for(int i = 0; i < score.toArray().length; i++){
                String row;
                if(i == 9)
                    row = "|| " + (i + 1) + " - " + name.get(i) + formatScore(score.get(i)) + " ||\n";
                else
                    row = "|| " + (i + 1) + "  - " + name.get(i) + formatScore(score.get(i)) + " ||\n";
                myWriter.write(row);
            }
            myWriter.write("||                              ||\n");
            myWriter.write("||    PRESS ESC TO GO BACK      ||\n");
            myWriter.write("==================================\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        public void writeName(char c) {
            if(nickName.length() + 1 <= LIMITCHAR) nickName += c;
            nickNameSpaces = "";
            for (char ch : nickName.toCharArray()) {
                nickNameSpaces += ch + " ";
            }
            for (int i = 0; i < (LIMITCHAR - nickName.length()); i++)
                nickNameSpaces += "_ ";
            getScreenView().setNickNameSpaces(nickNameSpaces);
        }
    }




}
**/