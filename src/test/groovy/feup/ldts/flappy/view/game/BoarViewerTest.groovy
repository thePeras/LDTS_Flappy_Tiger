import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.model.game.collectables.Boar
import feup.ldts.flappy.view.Colors
import feup.ldts.flappy.view.game.BoarViewer
import spock.lang.Specification

class BoarViewerTest extends Specification {
    def 'draw method should draw a pixel at each position of the Boar element with the correct character, foreground color, and background color'() {
        given:
        def boar = new Boar(Mock(Position))
        def gui = Mock(GUI)
        def boarViewer = new BoarViewer()

        when:
        boarViewer.draw(boar, gui)

        then:
        1 * gui.drawPixel(_, 134, Colors.BROWN.getHex(), Colors.BLUE.getHex())
        1 * gui.drawPixel(_, 135, Colors.BROWN.getHex(), Colors.BLUE.getHex())
    }
}
