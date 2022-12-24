package feup.ldts.flappy.view.menu

import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.model.menu.Pause
import spock.lang.Specification

class PauseViewerTest extends Specification {

    def "drawInsideElements should draw the title and the pause options"() {
        given:
        def pause = new Pause()
        def viewer = new PauseViewer(pause)
        def gui = Mock(GUI)

        when:
        viewer.drawInsideElements(gui)

        then:
        1 * gui.drawText(_, 'Pause', _, _)
    }

    def "drawOptions should draw the options"() {
        given:
        def pause = new Pause()
        def viewer = new PauseViewer(pause)
        def gui = Mock(GUI)

        when:
        viewer.drawOptions(gui)

        then:
        1 * gui.drawText(_, ">Resume", _, _)
        1 * gui.drawText(_, "Restart", _, _)
        1 * gui.drawText(_, "Main Menu", _, _)
    }
}
