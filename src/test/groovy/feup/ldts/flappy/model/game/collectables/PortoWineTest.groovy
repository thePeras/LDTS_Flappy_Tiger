package feup.ldts.flappy.model.game.collectables

import feup.ldts.flappy.model.game.elements.Game
import feup.ldts.flappy.model.game.elements.Player
import feup.ldts.flappy.model.game.Position
import spock.lang.Specification

class PortoWineTest extends Specification{
    def 'isCollidingWithPlayer is true'() {
        given:
            Player player = Mock(Player)
            Position position = Mock(Position)
            PortoWine portoWine = new PortoWine(position)
        when:
            player.getPositions() >> [position]
        then:
            portoWine.isCollidingWithPlayer(player) == true
    }

    def 'isCollidingWithPlayer is false'() {
        given:
            Position position = new Position(1, 1)
            PortoWine portoWine = new PortoWine(position)
            Player player = Mock(Player)
            Position position2 = new Position(2, 1)
        when:
            player.getPositions() >> [position2]
        then:
            portoWine.isCollidingWithPlayer(player) == false
    }

    def 'consume method'(){
        given:
            Position position = Mock(Position)
            PortoWine portoWine = new PortoWine(position)
            Game game = Mock(Game)
        when:
            portoWine.consume(game)
        then:
            1 * game.startGodMode()
    }
}
