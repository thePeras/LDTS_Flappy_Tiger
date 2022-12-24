import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.model.game.collectables.PortoWine
import feup.ldts.flappy.view.Colors
import feup.ldts.flappy.view.game.PortoWineViewer
import spock.lang.Specification

class PortoWineViewerTest extends Specification {
    def 'draw method should draw the PortoWine element with the correct character, foreground color, and background color'() {
        given:
        def portoWine = new PortoWine(Mock(Position))
        def gui = Mock(GUI)
        def portoWineViewer = new PortoWineViewer()

        when:
        portoWineViewer.draw(portoWine, gui)

        then:
        1 * gui.drawPixel(_, 132, Colors.DARK_BLUE.getHex(), Colors.BLUE.getHex())
        1 * gui.drawPixel(_, 133, Colors.DARK_BLUE.getHex(), Colors.BLUE.getHex())
    }
}
