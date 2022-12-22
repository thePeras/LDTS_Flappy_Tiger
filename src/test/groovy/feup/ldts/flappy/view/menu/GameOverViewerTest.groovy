import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.gui.LanternaGUI
import feup.ldts.flappy.view.menu.GameOverViewer
import feup.ldts.flappy.model.menu.GameOver
import org.junit.Assert
import org.junit.Test
import spock.lang.Specification

class GameOverViewerTest extends Specification {
    def 'should display game over message, score, enter name field and user name'() {
        given:
        def model = new GameOver(10)
        def viewer = new GameOverViewer(model)
        def gui = Mock(GUI)

        when:
        viewer.drawInsideElements(gui)

        then:
        1 * gui.drawText(_, 'G A M E   O V E R', _ , _)
        1 * gui.drawText(_, 'Score: 10' , _ , _)
        1 * gui.drawText(_, 'Enter your name:' ,_ , _)
        1 * gui.drawText(_, model.username,_ , _)
    }
}
