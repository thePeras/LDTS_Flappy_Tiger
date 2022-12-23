package feup.ldts.flappy.controller.game

import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.model.game.creators.WallCreator
import spock.lang.Specification


class ElementsFactoryTest extends Specification{
    def 'generateWall() should create a wall'() {
        given:
        ElementsFactory factory = new ElementsFactory(new Game())

        when:
        factory.generateWall()

        then:
        WallCreator wallCreator = new WallCreator()
        wallCreator.create() != null
    }
}
