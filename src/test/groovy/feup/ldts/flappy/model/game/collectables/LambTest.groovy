package feup.ldts.flappy.model.game.collectables

import feup.ldts.flappy.model.game.elements.Game
import feup.ldts.flappy.model.game.elements.Player
import feup.ldts.flappy.model.game.Position
import spock.lang.Specification

class LambTest extends Specification{
    def 'isCollidingWithPlayer is true'() {
        given:
            Player player = Mock(Player)
            Position position = Mock(Position)
            Lamb lamb = new Lamb(position)
        when:
            player.getPositions() >> [position]
        then:
            lamb.isCollidingWithPlayer(player) == true
    }

    def 'isCollidingWithPlayer is false'() {
        given:
            Position position = new Position(1, 1)
            Lamb lamb = new Lamb(position)
            Player player = Mock(Player)
            Position position2 = new Position(2, 1)
        when:
            player.getPositions() >> [position2]
        then:
            lamb.isCollidingWithPlayer(player) == false
    }

    def 'consume method'(){
        given:
            Position position = Mock(Position)
            Lamb lamb = new Lamb(position)
            Game game = Mock(Game)
        when:
            lamb.consume(game)
        then:
            1 * game.incrementScore(5)
    }
}
