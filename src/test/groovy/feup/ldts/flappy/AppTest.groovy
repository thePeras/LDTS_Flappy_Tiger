import feup.ldts.flappy.App
import feup.ldts.flappy.controller.game.GameController
import feup.ldts.flappy.controller.menu.GameOverController
import feup.ldts.flappy.controller.menu.MainMenuController
import feup.ldts.flappy.controller.menu.TextMenuController
import feup.ldts.flappy.controller.sound.Musics
import feup.ldts.flappy.controller.sound.SoundEffects
import feup.ldts.flappy.controller.sound.SoundManager
import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.model.menu.GameOver
import feup.ldts.flappy.state.AppState
import feup.ldts.flappy.view.menu.LeaderboardViewer
import feup.ldts.flappy.view.menu.MainMenuViewer
import spock.lang.Specification


class AppTest extends Specification {

    def "testInitialStateIsMenuState"() {
        given:
        def app = new App()

        expect:
        app.state == AppState.MenuState
    }


    def "testControllerAndViewerAreSetOnMenuState"() {
        given:
        def app = new App()

        when:
        app.setState(AppState.MenuState)

        then:
        app.controller instanceof MainMenuController
        app.viewer instanceof MainMenuViewer
    }

    def "testControllerAndViewerAreSetOnLeaderboardState"() {
        given:
        def app = new App()

        when:
        app.setState(AppState.LeaderboardState)

        then:
        app.controller instanceof TextMenuController
        app.viewer instanceof LeaderboardViewer
    }
     def "test new game"() {
            given:
            App app = new App()

            when:
            app.setState(AppState.GameState)
            Game game = app.game

            then:
            app.setState(AppState.GameOverState)
            assert app.controller instanceof GameOverController

        }
    }

