import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.model.game.collectables.Boar
import feup.ldts.flappy.model.game.collectables.Lamb
import feup.ldts.flappy.view.Colors
import feup.ldts.flappy.view.game.BoarViewer
import feup.ldts.flappy.view.game.LambViewer
import spock.lang.Specification

class LambViewerTest extends Specification {
    def 'draw method should draw a pixel at each position of the Lamb element with the correct character, foreground color, and background color'() {
        given:
        def lamb = new Lamb(Mock(Position))
        def gui = Mock(GUI)
        def lambViewer = new LambViewer()

        when:
        lambViewer.draw(lamb, gui)

        then:
        1 * gui.drawPixel(_, 136, Colors.WHITE.getHex(), Colors.BLUE.getHex());
    }
}
