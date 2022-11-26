package feup.ldts.flappy.model.menu;

public class Instructions extends Menu {
    private final String[] inst = new String[19];

    public Instructions() {
        super();
        inst[0] = "The goal of the game is to";
        inst[1] = "avoid colliding with the";
        inst[2] = "walls and the ground.";
        inst[3] = "";
        inst[4] = "The player can jump by";
        inst[5] = "pressing the space bar.";
        inst[6] = "Otherwise, the tiger will";
        inst[7] = "fall and hit the floor.";
        inst[8] = "";
        inst[9] = "You can collect boar and";
        inst[10] = "lamb to get extra points.";
        inst[11] = "";
        inst[12] = "Boar - 3 Points";
        inst[13] = "Lamb - 5 Points";
        inst[14] = "";
        inst[15] = "If you collect a bottle of";
        inst[16] = "wine, you enter god mode";
        inst[17] = "and the gap between walls";
        inst[18] = "will be bigger.";
    }

    public int getNumberEntries() {
        return inst.length;
    }

    public String getEntry(int i) {
        return this.inst[i];
    }

    public String[] getInstructions() {
        return inst;
    }
}
