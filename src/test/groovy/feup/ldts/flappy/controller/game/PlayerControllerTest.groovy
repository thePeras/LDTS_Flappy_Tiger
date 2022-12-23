package feup.ldts.flappy.controller.game

import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import feup.ldts.flappy.App
import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.model.game.collectables.Collectable
import feup.ldts.flappy.model.game.elements.Collidable
import feup.ldts.flappy.model.game.elements.Player
import spock.lang.Specification
import feup.ldts.flappy.model.game.collectables.PortoWine
import static org.junit.Assert.assertEquals


class PlayerControllerTest extends Specification {

    def "test jumpPlayer"() {
        given:
        Game game = new Game()
        Player player = game.getPlayer();
        PlayerController controller = new PlayerController(game)

        when:
        controller.jumpPlayer()

        then:
        player.getVelocity() == -3
    }

    def "test updatePosition"() {
        given:
        Game game = new Game()
        Player player = game.getPlayer();
        PlayerController controller = new PlayerController(game)
        player.setVelocity(velocity)
        player.getPosition().setY(y)

        when:
        controller.updatePosition()

        then:
        player.getPosition().getY() == expectedY

        where:
        velocity | y  | expectedY
        0        | 0  | 0
        0        | 1  | 1
        0        | -1 | -1
    }

    def "test updatePosition with collision"() {
        given:
        Game game = new Game()
        Player player = game.getPlayer();
        PlayerController controller = new PlayerController(game)
        player.setVelocity(velocity)
        player.getPosition().setY(y)

        when:
        controller.updatePosition()

        then:
        player.getPosition().getY() == expectedY

        where:
        velocity | y  | expectedY
        0        | 0  | 0
        0        | 1  | 1
        0        | -1 | -1
    }

    def "test isCollidingWith with PortoWine"() {
        given:
        // Create a PlayerController object
        Game game = Mock(Game)
        game.player >> new Player(new Position(5, 5))
        PlayerController playerController = new PlayerController(game)

        def collectable = new PortoWine(new Position(5, 5))

        expect:
        // Call the isCollidingWith method and assert that it returns true
        playerController.isCollidingWith(collectable) == true

    }

    def "test step"() {
        given:
        // Create a PlayerController object
        Game game = Mock(Game)
        game.player >> new Player(new Position(5, 5))
        PlayerController playerController = new PlayerController(game)

        // Create an App object
        App app = Mock(App)

        // Create a KeyStroke object with the character ' '
        Character character = ' '
        KeyStroke key = new KeyStroke(character, false, false)

        when:
        // Call the step method
        playerController.step(app, key)

        then:
        // Assert that the player's position and velocity have been updated correctly
        playerController.getModel().getPlayer().getPosition().getY() == 4
        playerController.getModel().getPlayer().getVelocity() == -3
    }
}
