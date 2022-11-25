package feup.ldts.flappy.view.game;

import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
