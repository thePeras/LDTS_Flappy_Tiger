import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.model.game.elements.Wall
import feup.ldts.flappy.view.Colors
import feup.ldts.flappy.view.game.WallViewer
import spock.lang.Specification

class WallViewerTest extends Specification {
    def 'draw method should draw the Wall element with the correct position, width, height, and color'() {
        given:
        def wall = new Wall(9)
        def gui = Mock(GUI)
        def wallViewer = new WallViewer()

        when:
        wallViewer.draw(wall, gui)

        then:
        1 * gui.drawRectangle(wall.getPosition(), wall.getWidth(), wall.getHeight(), Colors.GREEN.getHex())
        1 * gui.drawRectangle(new Position(wall.getPosition().getX(), wall.getHeight() + wall.getSpace()), wall.getWidth(), gui.getHeight() - (wall.getHeight() + wall.getSpace()), Colors.GREEN.getHex())
    }
}
