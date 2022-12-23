/*
package feup.ldts.flappy.controller.game

import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.model.game.collectables.Collectable
import feup.ldts.flappy.model.game.collectables.PortoWine
import feup.ldts.flappy.model.game.creators.WallCreator
import spock.lang.Specification


class CollisionControllerTest extends Specification{
def "testCollectablesAreConsumedOnCollision"() {
    given:
    def game = Mock(Game)
    def playerController = Mock(PlayerController)
    def collectable = (Collectable)new PortoWine(Mock(Position))
    game.getCollectables() >> [collectable]
    playerController.isCollidingWith(collectable) >> true
    def collisionController = new CollisionController(game, playerController)

    when:
    collisionController.step(Mock(App), Mock(KeyStroke))

    then:
    1 * game.consumeCollectable(collectable)
    1 * game.getCollectables().remove(collectable)
}
*/