package feup.ldts.flappy.model.game.elements

import feup.ldts.flappy.model.game.Position
import spock.lang.Specification

class WallTest extends Specification {

    def 'Default values for height and space'() {
        given:
        def wall = new Wall(10)
        expect:
        wall.height == 10
        wall.space == 11
    }

    def 'setSpace should correctly set space and adjust height'() {
        given:
        def wall = new Wall(35)
        when:
        wall.setSpace(15)
        then:
        wall.height == 28
    }

    def 'isGapHeight method'() {
        given:
        def wall = new Wall(10)
        expect:
        wall.isGapHeight(11) == true
        wall.isGapHeight(12) == true
        wall.isGapHeight(14) == true
        wall.isGapHeight(15) == true
    }

    def 'isGapHeight should return false for y outside gap'() {
        given:
        def wall = new Wall(10)
        expect:
        wall.isGapHeight(9) == false
        wall.isGapHeight(0) == false
    }

    def 'isOutOfScreen in x=#x: #expected'() {
        given:
        def wall = new Wall(10)
        wall.setPosition(new Position(x, 0))
        expect:
        wall.isOutOfScreen() == expected
        where:
        x  | expected
        -2 | true
        -1 | false
        0  | false
        1  | false
    }

    def 'move'() {
        given:
        def wall = new Wall(10)
        wall.setPosition(new Position(10, 0))
        when:
        wall.move()
        then:
        wall.getPosition().x == 9
    }
    def "Test getPosition()"() {
        given:
        def wall = new Wall(10)
        wall.setPosition(new Position(10, 0))
        expect:
        wall.getPosition().x == 10
        wall.getPosition().y == 0
    }
    def "getPositions should return the correct positions for a wall"() {
        given:
        def wall = new Wall(5)
        wall.setSpace(3)
        wall.setX(10)

        when:
        def positions = wall.getPositions()

        then:
        def expectedPositions = []
        for (int y = -5; y <= 35; y++) {
            if (!wall.isGapHeight(y)) {
                expectedPositions << new Position(10, y)
                expectedPositions << new Position(11, y)
            }
        }
        positions == expectedPositions
    }
}