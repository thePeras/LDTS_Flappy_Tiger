package feup.ldts.flappy.model.game.collectables

import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.model.game.Position
import spock.lang.Specification

class PortoWineTest extends Specification{
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
