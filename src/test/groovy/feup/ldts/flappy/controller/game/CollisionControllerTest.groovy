import com.googlecode.lanterna.input.KeyStroke
import feup.ldts.flappy.App
import feup.ldts.flappy.controller.game.CollisionController
import feup.ldts.flappy.controller.game.PlayerController
import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.model.game.elements.Player
import feup.ldts.flappy.state.AppState
import spock.lang.Specification

class CollisionControllerTest extends Specification {


    def "test step with floor collision"() {
        given:
        App app = Mock(App)
        Game game = new Game()
        game.player >> new Player(new Position(5, 5))

        PlayerController playerController = new PlayerController(game)

        CollisionController collisionController = new CollisionController(game, playerController)
        collisionController.getModel() >> game

        Character character = ' '
        KeyStroke key = new KeyStroke(character, false, false)

        game.player.getPosition().setY(34)

        when:
        collisionController.step(app, key)

        then:
        1 * app.setState(AppState.GAME_OVER_STATE)
    }

}