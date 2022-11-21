package feup.ldts.tanktrouble.viewer;

import feup.ldts.tanktrouble.gui.GUI;
import feup.ldts.tanktrouble.model.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
