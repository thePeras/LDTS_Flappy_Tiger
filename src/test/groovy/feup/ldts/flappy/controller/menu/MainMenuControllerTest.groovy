package feup.ldts.flappy.controller.menu

import feup.ldts.flappy.App
import feup.ldts.flappy.model.menu.MainMenu
import feup.ldts.flappy.model.menu.Menu
import spock.lang.Specification
//Import appState
import feup.ldts.flappy.state.AppState

class MainMenuControllerTest extends Specification {
    def "test optionSelected sets game state to GameState when start option is selected"() {
        given:
        MainMenu mainMenu = (Menu) new MainMenu()
        mainMenu.option = 0
        MainMenuController controller = new MainMenuController(mainMenu)
        App game = Mock(App)
        when:

        when:
        controller.optionSelected(game)

        then:
        1 * game.setState(AppState.GameState)
    }

    def "test optionSelected sets game state to LeaderboardState when leaderboard option is selected"() {
        given:
        MainMenu mainMenu = (Menu) new MainMenu()
        mainMenu.option = 1
        MainMenuController controller = new MainMenuController(mainMenu)
        App game = Mock(App)

        when:
        controller.optionSelected(game)

        then:
        1 * game.setState(AppState.LeaderboardState)
    }

    def "test optionSelected sets game state to InstructionsState when instructions option is selected"() {
        given:
        MainMenu mainMenu = (Menu) new MainMenu()
        mainMenu.option = 2
        MainMenuController controller = new MainMenuController(mainMenu)
        App game = Mock(App)

        when:
        controller.optionSelected(game)

        then:
        1 * game.setState(AppState.InstructionsState)
    }

    def "test optionSelected closes the application when exit option is selected"() {
        given:
        MainMenu mainMenu = (Menu) new MainMenu()
        mainMenu.option = 3
        MainMenuController controller = new MainMenuController(mainMenu)
        App game = Mock(App)

        when:
        controller.optionSelected(game)

        then:
        1 * game.exit()
    }


}