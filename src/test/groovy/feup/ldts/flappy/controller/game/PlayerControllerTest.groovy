package feup.ldts.flappy.controller.game

import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.model.game.elements.Player
import spock.lang.Specification

class PlayerControllerTest extends Specification{

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
        velocity | y | expectedY
        0 | 0 | 0
        0 | 1 | 1
        0 | -1 | -1
    }
}