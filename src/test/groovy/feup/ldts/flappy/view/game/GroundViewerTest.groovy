import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.model.game.elements.Ground
import feup.ldts.flappy.view.Colors
import feup.ldts.flappy.view.game.GroundViewer
import spock.lang.Specification

class GroundViewerTest extends Specification {
    def 'draw method should paint the Ground element at the correct position with the correct color'() {
        given:
        GUI gui = Mock(GUI)
        Ground ground = Mock(Ground)
        Position position = Mock(Position)
        ground.getPosition() >> position
        position.getY() >> 10
        when:
        new GroundViewer().draw(ground, gui)
        then:
        1 * gui.paintPixel(_, Colors.DARK_GREEN.getHex()) >> _
    }
}
