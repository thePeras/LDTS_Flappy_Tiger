import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.view.Colors
import feup.ldts.flappy.view.Viewer
import feup.ldts.flappy.view.game.GameViewer
import feup.ldts.flappy.view.game.GroundViewer
import feup.ldts.flappy.view.game.PlayerViewer
import feup.ldts.flappy.view.game.WallViewer
import spock.lang.Specification

class GameViewerTest extends Specification {
    def 'drawElements method should set the right background color, draw a white rectangle, and right the score '() {
        given:
        def game = new Game(/* parameters */)
        def gui = Mock(GUI)
        def gameViewer = new GameViewer(game)
        when:

        when:
        gameViewer.drawElements(gui)

        then:
        1 * gui.paintBackground(Colors.BLUE.getHex())
        1 * gui.drawRectangle(new Position(0, 0), _, 3, Colors.WHITE.getHex())
        1 * gui.drawText(new Position(1, 1), 'SCORE: ' + game.getScore(), Colors.ORANGE.getHex(), Colors.WHITE.getHex())
    }
}
