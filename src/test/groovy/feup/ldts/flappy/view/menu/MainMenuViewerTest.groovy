import feup.ldts.flappy.gui.GUI
import feup.ldts.flappy.model.menu.MainMenu
import feup.ldts.flappy.view.menu.MainMenuViewer
import spock.lang.Specification

class MainMenuViewerTest extends Specification {

    def "drawInsideElements should draw the title and the curiosity message"() {
        given:
        def mainMenu = new MainMenu()
        def viewer = new MainMenuViewer(mainMenu)
        def gui = Mock(GUI)
        String[] curiosity = mainMenu.getCuriosity().split("\n");
        int size = curiosity.length - 1;

        when:
        viewer.drawInsideElements(gui)

        then:
        1 * gui.drawText(_, 'Main Menu', _, _)
        1 * gui.drawPixel(_, _, _, _)
        size * gui.drawLine(_, _, _)

    }

    def "drawOptions should draw the options"() {
        given:
        def mainMenu = new MainMenu()
        def viewer = new MainMenuViewer(mainMenu)
        def gui = Mock(GUI)

        when:
        viewer.drawOptions(gui)

        then:
        1 * gui.drawText(_, ">Start", _, _)
        1 * gui.drawText(_, "Instructions", _, _)
        1 * gui.drawText(_, "Leaderboard", _, _)
        1 * gui.drawText(_, "Exit", _, _)

    }
}