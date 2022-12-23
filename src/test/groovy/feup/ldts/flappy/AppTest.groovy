import feup.ldts.flappy.App
import feup.ldts.flappy.controller.menu.GameOverController
import feup.ldts.flappy.controller.menu.MainMenuController
import feup.ldts.flappy.controller.menu.TextMenuController
import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.state.AppState
import feup.ldts.flappy.view.menu.LeaderboardViewer
import feup.ldts.flappy.view.menu.MainMenuViewer
import spock.lang.Specification


class AppTest extends Specification {

    def "testInitialStateIsMenuState"() {
        given:
        def app = new App()

        expect:
        app.state == AppState.MENU_STATE
    }


    def "testControllerAndViewerAreSetOnMenuState"() {
        given:
        def app = new App()

        when:
        app.setState(AppState.MENU_STATE)

        then:
        app.controller instanceof MainMenuController
        app.viewer instanceof MainMenuViewer
    }

    def "testControllerAndViewerAreSetOnLeaderboardState"() {
        given:
        def app = new App()

        when:
        app.setState(AppState.LEADERBOARD_STATE)

        then:
        app.controller instanceof TextMenuController
        app.viewer instanceof LeaderboardViewer
    }
     def "test new game"() {
            given:
            App app = new App()

            when:
            app.setState(AppState.GAME_STATE)
            Game game = app.game

            then:
            app.setState(AppState.GAME_OVER_STATE)
            assert app.controller instanceof GameOverController

        }
    }

