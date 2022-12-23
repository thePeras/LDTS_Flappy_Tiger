import feup.ldts.flappy.view.menu.InstructionsViewer
import feup.ldts.flappy.model.menu.Instructions
import feup.ldts.flappy.gui.GUI
import spock.lang.Specification

class InstructionsViewerTest extends Specification {

    def "drawInsideElements should draw the title and the instructions lines"() {
        given:
        def instructions = new Instructions()
        def viewer = new InstructionsViewer(instructions)
        def gui = Mock(GUI)

        when:
        viewer.drawInsideElements(gui)

        then:
        1 * gui.drawText(_, 'Instructions', _,_)
        19 * gui.drawText(_, _, _,_)
    }

    def "drawOptions should not draw any options"() {
        given:
        def instructions = new Instructions()
        def viewer = new InstructionsViewer(instructions)
        def gui = Mock(GUI)

        when:
        viewer.drawOptions(gui)

        then:
        0 * gui.drawText(_, _, _,_)
    }
}
