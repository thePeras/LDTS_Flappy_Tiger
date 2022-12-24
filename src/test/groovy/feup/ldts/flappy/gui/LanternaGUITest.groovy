package feup.ldts.flappy.gui

import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.screen.Screen
import feup.ldts.flappy.model.game.Position
import spock.lang.Specification

class LanternaGUITest extends Specification {
    def gui, screen, textGraphics

    def setup() {
        screen = Mock(Screen)
        gui = new LanternaGUI(screen)
        textGraphics = Mock(TextGraphics)
        screen.newTextGraphics() >> textGraphics
    }

    def "screen clear"() {
        when:
        gui.clear()
        then:
        1 * screen.clear()
    }

    def "screen refresh"() {
        when:
        gui.refresh()
        then:
        1 * screen.refresh()
    }

    def "screen close"() {
        when:
        gui.close()
        then:
        1 * screen.close()
    }

    def "paint pixel (#x, #y)"() {
        given:
        def position = new Position(x, y)
        when:
        gui.paintPixel(position, '#ffffff')
        then:
        1 * textGraphics.setBackgroundColor(_)
        1 * textGraphics.putString(x, y, " ")
        where:
        x | y
        1 | 2
        2 | 3
    }

    def "draw pixel (#x, #y)"() {
        given:
        def position = new Position(x, y)
        def color = "#ffffff"
        def backgroundColor = "#000000"
        char myChar = 'a'
        when:
        gui.drawPixel(position, myChar, color, backgroundColor)
        then:
        1 * textGraphics.setForegroundColor(TextColor.Factory.fromString(color))
        1 * textGraphics.setBackgroundColor(TextColor.Factory.fromString(backgroundColor))
        1 * textGraphics.putString(x, y, "" + myChar);
        where:
        x | y
        1 | 2
        2 | 3
    }

    def "drawRectangle"() {
        given:
        def position = new Position(1, 2)
        def width = 3
        def height = 4
        def color = "#ffffff"
        when:
        gui.drawRectangle(position, width, height, color)
        then:
        1 * textGraphics.setBackgroundColor(TextColor.Factory.fromString(color))
        1 * textGraphics.drawRectangle(_, _, _)
    }

    def "paintBackground"() {
        given:
        def color = "#ffffff"
        when:
        gui.paintBackground(color)
        then:
        1 * textGraphics.setBackgroundColor(TextColor.Factory.fromString(color))
        1 * textGraphics.fillRectangle(_, _, _)
    }


    def "drawLine (#x, #y)"() {
        given:
        def position = new Position(x, y)
        def text = "random text here"
        def color = "#ffffff"
        when:
        gui.drawLine(position, text, color)
        then:
        1 * textGraphics.setForegroundColor(_)
        1 * textGraphics.setBackgroundColor(_)
        1 * textGraphics.putString(x, y, "" + (char) 138)
        1 * textGraphics.setForegroundColor(TextColor.Factory.fromString(color))
        1 * textGraphics.setBackgroundColor(_)
        1 * textGraphics.putString(x + 1, y, text)
        where:
        x | y
        1 | 2
        2 | 3
    }

    def "drawText"() {
        given:
        def position = new Position(1, 2)
        def text = "text"
        def color = "#ffffff"
        def backgroundColor = "#000000"
        when:
        gui.drawText(position, text, color, backgroundColor)
        then:
        1 * textGraphics.setForegroundColor(TextColor.Factory.fromString(color))
        1 * textGraphics.setBackgroundColor(TextColor.Factory.fromString(backgroundColor))
        1 * textGraphics.putString(1, 2, text)
    }

    def "getNextAction"() {
        given:
        def action = KeyStroke.fromString("a")
        screen.pollInput() >> action
        when:
        def result = gui.getNextAction()
        then:
        result == action
    }
}


