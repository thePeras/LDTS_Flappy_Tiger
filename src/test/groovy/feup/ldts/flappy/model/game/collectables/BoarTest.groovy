package feup.ldts.flappy.model.game.collectables

import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.model.game.Position
import spock.lang.Specification

class BoarTest extends Specification {
    def 'getPositions size 2'() {
        given:
            Position position = Mock(Position)
            Boar boar = new Boar(position)
        when:
            boar.getPositions()
        then:
            boar.getPositions().size() == 2
    }

    def 'positions have the same y coordinate'(){
        given:
        Position position = Mock(Position)
        Boar boar = new Boar(position)
        when:
        boar.getPositions()
        then:
        boar.getPositions()[0].getY() == boar.getPositions()[1].getY()
    }

    def 'positions have different x coordinate'(){
        given:
            Position position = Mock(Position)
            Boar boar = new Boar(position)
        when:
            boar.getPositions()
        then:
            boar.getPositions()[0].getX() != boar.getPositions()[1].getX()
    }

    def 'consume method'(){
        given:
            Position position = Mock(Position)
            Boar boar = new Boar(position)
            Game game = Mock(Game)
        when:
            boar.consume(game)
        then:
            1 * game.incrementScore(3)
    }
}
