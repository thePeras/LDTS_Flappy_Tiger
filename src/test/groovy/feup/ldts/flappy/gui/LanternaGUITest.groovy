package feup.ldts.flappy.gui

import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.Screen
import feup.ldts.flappy.model.game.Position;
import spock.lang.Specification;

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

    def "paint pixel (#x, #y)"(){
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
}


