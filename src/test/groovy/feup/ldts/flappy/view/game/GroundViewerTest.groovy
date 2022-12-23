import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.model.game.elements.Ground
import feup.ldts.flappy.view.Colors
import feup.ldts.flappy.view.game.GroundViewer
import spock.lang.Specification

class GroundViewerTest extends Specification {
    def 'draw method should paint the Ground element at the correct position with the correct color'() {
        given:
        def ground = new Ground(1)
        def gui = Mock(GUI)
        def groundViewer = new GroundViewer()
        when:
        groundViewer.draw(ground, gui)

        then:
        for (int x = 0; x <= gui.getWidth(); x++) {
            1 * gui.paintPixel(new Position(x, ground.getPosition().getY()), Colors.DARK_GREEN.getHex())
        }
    }
}
