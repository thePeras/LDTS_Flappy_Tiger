import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.model.game.elements.Player
import feup.ldts.flappy.view.Colors
import feup.ldts.flappy.view.game.PlayerViewer
import spock.lang.Specification

class PlayerViewerTest extends Specification {
    def 'draw method should draw the Player element with the correct character, foreground color, and background color'() {
        given:
        def player = new Player(Mock(Position))
        def gui = Mock(GUI)
        def playerViewer = new PlayerViewer()

        when:
        playerViewer.draw(player, gui)

        then:
        1 * gui.drawPixel(_, 128, Colors.ORANGE.getHex(), Colors.BLUE.getHex())
        1 * gui.drawPixel(_, 129, Colors.ORANGE.getHex(), Colors.BLUE.getHex())
        1 * gui.drawPixel(_, 130, Colors.ORANGE.getHex(), Colors.BLUE.getHex())
        1 * gui.drawPixel(_, 131, Colors.ORANGE.getHex(), Colors.BLUE.getHex())
    }
}

