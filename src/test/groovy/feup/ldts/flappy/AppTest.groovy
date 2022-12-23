import feup.ldts.flappy.App
import feup.ldts.flappy.controller.game.GameController
import feup.ldts.flappy.controller.menu.GameOverController
import feup.ldts.flappy.controller.menu.MainMenuController
import feup.ldts.flappy.controller.menu.PauseController
import feup.ldts.flappy.controller.menu.TextMenuController
import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.state.AppState
import feup.ldts.flappy.view.game.GameViewer
import feup.ldts.flappy.view.menu.GameOverViewer
import feup.ldts.flappy.view.menu.InstructionsViewer
import feup.ldts.flappy.view.menu.LeaderboardViewer
import feup.ldts.flappy.view.menu.MainMenuViewer
import feup.ldts.flappy.view.menu.PauseViewer
import spock.lang.Specification


class AppTest extends Specification {

    def "testInitialStateIsMenuState"() {
        given:
        def app = new App()

        expect:
        app.state == AppState.MenuState
        app.controller instanceof MainMenuController
        app.viewer instanceof MainMenuViewer
    }

    def "setState method"() {
        given:
        def app = new App()
        def game = Mock(Game)
        game.getScore() >> 0
        app.game = game

        when:
        app.setState(state)

        then:
        app.controller in expectedController
        app.viewer in expectedViewer

        where:
        state | expectedController | expectedViewer
        AppState.GameState | GameController | GameViewer
        AppState.LeaderboardState |  TextMenuController | LeaderboardViewer
        AppState.InstructionsState | TextMenuController | InstructionsViewer
        AppState.PauseState | PauseController | PauseViewer
        AppState.GameOverState | GameOverController | GameOverViewer
    }

    def "testExitMethod"() {
        given:
        def app = new App()

        when:
        app.exit()

        then:
        app.state == null
    }

}

