import feup.ldts.flappy.model.menu.Leaderboard
import feup.ldts.flappy.view.menu.InstructionsViewer
import feup.ldts.flappy.model.menu.Instructions
import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.view.menu.LeaderboardViewer
import spock.lang.Specification

class LeaderboardViewerTest extends Specification {

    def "drawInsideElements should draw the title and the leaderboard lines"() {
        given:
        def instructions = new Leaderboard()
        def viewer = new LeaderboardViewer(instructions)
        def gui = Mock(GUI)


        when:
        viewer.drawInsideElements(gui)

        then:
        1 * gui.drawText(_, 'Leaderboard', _,_)
        5 * gui.drawText(_, _, _,_)
    }

    def "drawOptions should not draw any options"() {
        given:
        def instructions = new Leaderboard()
        def viewer = new LeaderboardViewer(instructions)
        def gui = Mock(GUI)

        when:
        viewer.drawOptions(gui)

        then:
        0 * gui.drawText(_, _, _,_)
    }
}
