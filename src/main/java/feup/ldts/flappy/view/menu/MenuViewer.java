package feup.ldts.flappy.view.menu;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.view.Colors;
import feup.ldts.flappy.model.menu.Menu;
import feup.ldts.flappy.model.game.Position;
import feup.ldts.flappy.view.Viewer;

public abstract class MenuViewer<T extends Menu> extends Viewer<T> {
    private Integer options_x;
    private Integer options_y;

    public MenuViewer(T model, Position optionsPosition) {
        super(model);
        this.options_x = optionsPosition.getX();
        this.options_y = optionsPosition.getY();
    }

    protected void drawElements(GUI gui) {
        gui.paintBackground(Colors.MENU_BACKGROUND.getHex());

        drawOptions(gui);

        drawInsideElements(gui);
    }

    public void drawOptions(GUI gui) {
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (getModel().isSelected(i)) {
                drawText(gui, new Position(options_x, options_y + i), ">" + getModel().getEntry(i), Colors.ORANGE.getHex());
            } else {
                drawText(gui, new Position(options_x + 1, options_y + i), getModel().getEntry(i), Colors.WHITE.getHex());
            }
        }
    }

    public void drawTitle(GUI gui, String title, String color) {
        drawText(gui, new Position(options_x, options_y - 2), title, color);
    }

    public void drawText(GUI gui, Position position, String text, String color) {
        gui.drawText(position, text, color, Colors.MENU_BACKGROUND.getHex());
    }

    abstract protected void drawInsideElements(GUI gui);
}
