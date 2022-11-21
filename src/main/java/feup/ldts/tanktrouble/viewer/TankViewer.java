package feup.ldts.tanktrouble.viewer;

import feup.ldts.tanktrouble.gui.GUI;
import feup.ldts.tanktrouble.model.elements.Tank;

public class TankViewer implements ElementViewer<Tank> {
    @Override
    public void draw(Tank tank, GUI gui) {
        gui.drawTank(tank.getPosition());
    }
}
