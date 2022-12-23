package feup.ldts.flappy.model.game.elements


import spock.lang.Specification

class GroundTest extends Specification {

    def "Constructor sets the position correctly"() {
        given:
        def y = 0
        when:
        Ground ground = new Ground(y)
        then:
        ground.getPosition().getY() == y
        ground.getPosition().getX() == 0
    }
}
