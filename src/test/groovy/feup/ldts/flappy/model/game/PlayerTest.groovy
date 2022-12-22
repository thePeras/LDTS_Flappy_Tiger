package feup.ldts.flappy.model.game

import feup.ldts.flappy.model.game.elements.Player
import spock.lang.Specification

class PlayerTest extends Specification{
    def 'getVelocity() should return current velocity of the player'(){
        given:
            Player player = new Player(new Position(1,1))
            player.velocity = 1
        expect:
            player.getVelocity() == 1
    }

    def 'setVelocity()'(){
        given:
            Player player = new Player(new Position(1,1))
        when:
            player.setVelocity(3)
        then:
            player.velocity == 3
    }
    def 'setVelocity() maxVelocity'(){
        given:
        Player player = new Player(new Position(1,1))
        when:
        player.setVelocity(5)
        then:
        player.velocity == 3
    }

    def 'getGravity()'(){
        given:
            Player player = new Player(new Position(1,1))
        expect:
            player.getGravity() == 1
    }

    def 'getPositions()'(){
        given:
            Player player = new Player(new Position(1,1))
            def positions = [
                new Position(1,1),
                new Position(1,2),
                new Position(2,1),
                new Position(2,2)
            ]
        expect:
            player.getPositions().size() == 4
            positions.every { player.getPositions().contains(it) }
    }
}
