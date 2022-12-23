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

    def "When game is playing, generate wall and collectable at appropriate steps"() {
        given:
        Game game = Mock(Game)
        game.isPlaying() >> true
        game.getSteps() >> 0
        ElementsFactory elementsFactory = new ElementsFactory(game)

        when:
        elementsFactory.step()

        then:
        1 * game.addWall(_)
        0 * game.addCollectable(_)
        1 * game.incrementSteps()
    }

    def "When game is playing, generate wall and collectable at appropriate steps"() {
        given:
        Game game = Mock(Game)
        game.isPlaying() >> true
        game.getSteps() >> 10
        ElementsFactory elementsFactory = new ElementsFactory(game)

        when:
        elementsFactory.step()

        then:
        0 * game.addWall(_)
        1 * game.addCollectable(_)
        1 * game.incrementSteps()
    }
    def "generateCollectable() should call game.addCollectable() once when the random number is lower than GENERATE_COLLECTABLE_PROBABILITY"(){
        given:
        Game game = Mock(Game)
        ElementsFactory factory = new ElementsFactory(game)
        def random = Mock(Random)
        random.nextInt(100) >> ElementsFactory.GENERATE_COLLECTABLE_PROBABILITY - 1
        factory.random = random

        when:
        factory.generateCollectable()


        then:
        1 * game.addCollectable(_)
    }

    def "generateCollectable() should not call game.addCollectable() once when the random number is higher than GENERATE_COLLECTABLE_PROBABILITY"(){
        given:
        Game game = Mock(Game)
        ElementsFactory factory = new ElementsFactory(game)
        def random = Mock(Random)
        random.nextInt(100) >> ElementsFactory.GENERATE_COLLECTABLE_PROBABILITY + 1
        factory.random = random

        when:
        factory.generateCollectable()

        then:
        0 * game.addCollectable(_)
    }
}
