package feup.ldts.tanktrouble.viewer;

import feup.ldts.tanktrouble.gui.GUI;
import feup.ldts.tanktrouble.model.elements.Tank;

public class TankViewer implements ElementViewer<Tank> {
    private static final String[] tank_template = new String[]{
            "     HHHHHH     ",
            "     HGGGGH     ",
            "     HGGGGH     ",
            "     HGGGGH     ",
            "  HHHHGGGGHHHH  ",
            " BBGFHGGGGHFGBB ",
            "BBCGFHHGGHHFGCBB",
            "BCCGFFHGGHFFGCCB",
            "BCGGFFHGGHFFGGCB",
            "BCGGFFHGGHFFGGCB",
            "BCGGFGHGGHGFGGCB",
            "BCGGFGHGGHGFGGCB",
            "BCGGFGHHHHGFGGCB",
            "BCGGFGGGGGGFGGCB",
            "BCGGFFGGGGFFGGCB",
            "BCCGFFFFFFFFGCCB",
            "BBCGFFFFFFFFGCBB",
            " BBGFGGGGGGFGBB ",
            "  HHHHHHHHHHHH  ",
    };
    @Override
    public void draw(Tank tank, GUI gui) {
        gui.drawTank(tank.getPosition());
    }
}
