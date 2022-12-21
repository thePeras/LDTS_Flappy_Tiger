package feup.ldts.flappy.model.game

import spock.lang.Specification

class GroundTest extends Specification{

    def "Constructor sets the position correctly"() {
        given:
            def y = 0
        when:
            Ground ground = new Ground(y)
        then:
            ground.getPosition().getY() == y
            ground.getPosition().getX() == 0
    }

    def "isCollidingWithPlayer in (#x, #y)"() {
        given:
            Ground ground = new Ground(0)
            Position pos1 = new Position(x, y)
            Position pos2 = new Position(x+1, y)
            Position pos3 = new Position(x, y + 1)
            Position pos4 = new Position(x+1, y + 1)
            Player player = Mock(Player)
            player.getPositions() >> [pos1, pos2, pos3, pos4]
        when:
            def result = ground.isCollidingWithPlayer(player)
        then:
            result == expected
        where:
            x | y | expected
            0 | 0 | true
            0 | -1 | true
            0 | -2 | false
            0 | 1 | false
            0 | 2 | false
            1 | 0 | true
            1 | 1 | false
    }
}
