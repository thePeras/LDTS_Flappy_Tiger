package feup.ldts.flappy.controller.menu

import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import feup.ldts.flappy.App
import feup.ldts.flappy.controller.sound.SoundManager
import feup.ldts.flappy.model.menu.MainMenu
import feup.ldts.flappy.model.menu.Menu
import feup.ldts.flappy.state.AppState
import spock.lang.Specification

//Import appState

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
        1 * game.setState(AppState.GAME_STATE)
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
        1 * game.setState(AppState.LEADERBOARD_STATE)
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
        1 * game.setState(AppState.INSTRUCTIONS_STATE)
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

    def "step should move to the next option when arrow down is pressed"() {
        given:
        def menu = new MainMenu()
        menu.options = ['Option 1', 'Option 2', 'Option 3']
        def controller = new MainMenuController(menu)

        when:
        controller.step(null, new KeyStroke(KeyType.ArrowDown, false, false))

        then:
        menu.option == 1
    }

    def "step should move to the previous option when arrow up is pressed"() {
        given:
        def menu = new MainMenu()
        menu.options = ['Option 1', 'Option 2', 'Option 3']
        def controller = new MainMenuController(menu)

        when:
        controller.step(null, new KeyStroke(KeyType.ArrowUp, false, false))

        then:
        menu.option == 2
    }
}