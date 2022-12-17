package feup.ldts.flappy.model.game

import spock.lang.Specification

class PositionTest extends Specification{

    def "addX()"(){
        given:
            Position pos = new Position(2,3)
        when:
            pos.addX(7)
        then:
            pos.x == 9
            pos.y == 3
    }

    def "addY()"(){
        given:
            Position pos = new Position(2,3)
        when:
            pos.addY(9)
        then:
            pos.y == 12
            pos.x == 2
    }

    def "equals true"(){
        given:
            Position pos = new Position(2,3)
            Position pos2 = new Position(2,3)
        when:
            boolean result = pos == pos2
        then:
            result == true
    }

    def "equals false"(){
        given:
            Position pos = new Position(2,3)
            Position pos2 = new Position(2,4)
        when:
            boolean result = pos == pos2
        then:
            result == false
    }
}
