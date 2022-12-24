import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.model.game.collectables.Boar
import feup.ldts.flappy.model.game.collectables.Lamb
import feup.ldts.flappy.model.game.collectables.PortoWine
import feup.ldts.flappy.model.game.elements.Element
import feup.ldts.flappy.view.Colors
import feup.ldts.flappy.view.game.BoarViewer
import feup.ldts.flappy.view.game.GameViewer
import feup.ldts.flappy.view.game.LambViewer
import feup.ldts.flappy.view.game.PortoWineViewer
import spock.lang.Specification

class GameViewerTest extends Specification {
    def gameViewer

    def setup() {
        gameViewer = new GameViewer(new Game())
    }

    def 'test drawElements()'() {
        given:
        def gui = Mock(GUI)
        when:
        gameViewer.drawElements(gui)
        then:
        1 * gui.paintBackground(_);
        1 * gui.drawRectangle(_, _, _, _)
        1 * gui.drawText(_, _, _, _)
    }

    def 'test drawElement()'() {
        given:
        def gui = Mock(GUI)
        def boarViewer = Mock(BoarViewer)
        def boar = Mock(Boar)
        when:
        gameViewer.drawElement(gui, boar, boarViewer)
        then:
        1 * boarViewer.draw(_, _)
    }

    def 'test drawScore()'() {
        given:
        def gui = Mock(GUI)
        when:
        gameViewer.drawScore(gui)
        then:
        1 * gui.drawRectangle(_, _, _, _)
        1 * gui.drawText(_, _, _, _)
    }

    def 'test drawSky()'() {
        given:
        def gui = Mock(GUI)
        when:
        gameViewer.drawSky(gui)
        then:
        1 * gui.paintBackground(Colors.BLUE.getHex())
    }
}
