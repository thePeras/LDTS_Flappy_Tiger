import feup.ldts.flappy.App
import feup.ldts.flappy.controller.game.GameController
import feup.ldts.flappy.controller.menu.GameOverController
import feup.ldts.flappy.controller.menu.MainMenuController
import feup.ldts.flappy.controller.menu.PauseController
import feup.ldts.flappy.controller.menu.TextMenuController
import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.state.AppState
import feup.ldts.flappy.view.game.GameViewer
import feup.ldts.flappy.view.menu.*
import spock.lang.Specification

class AppTest extends Specification {

    def "testInitialStateIsMenuState"() {
        given:
        def app = new App()

        expect:
        app.state == AppState.MENU_STATE
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
        state                       | expectedController | expectedViewer
        AppState.GAME_STATE         | GameController     | GameViewer
        AppState.LEADERBOARD_STATE  | TextMenuController | LeaderboardViewer
        AppState.INSTRUCTIONS_STATE | TextMenuController | InstructionsViewer
        AppState.PAUSE_STATE        | PauseController    | PauseViewer
        AppState.GAME_OVER_STATE    | GameOverController | GameOverViewer
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

