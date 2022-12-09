package feup.ldts.flappy.gui;

import feup.ldts.flappy.model.game.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPixel(int x, int y, char c, String color);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    int getWidth();

    int getHeight();

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, JUMP, ESCAPE, SELECT}
}
