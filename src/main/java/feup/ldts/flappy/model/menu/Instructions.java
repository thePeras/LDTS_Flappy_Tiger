package feup.ldts.flappy.model.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Instructions {
    private final ArrayList<String> inst = new ArrayList<String>();

    public Instructions() throws FileNotFoundException {
        super();
        File instructionsFile = new File("src/main/resources/text/instructions.txt");
        Scanner scanner = new Scanner(instructionsFile);
        while (scanner.hasNextLine()) {
            inst.add(scanner.nextLine());
        }
    }

    public int getNumberEntries() {
        return inst.size();
    }

    public String getEntry(int i) {
        return inst.get(i);
    }

    public ArrayList<String> getInstructions() {
        return inst;
    }
}
