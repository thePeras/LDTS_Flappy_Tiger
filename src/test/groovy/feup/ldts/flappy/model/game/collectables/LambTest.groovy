package feup.ldts.flappy.model.game.collectables

import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.model.game.Position
import spock.lang.Specification

class LambTest extends Specification{
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
