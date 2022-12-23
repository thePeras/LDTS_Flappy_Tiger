package feup.ldts.flappy.controller.game

import feup.ldts.flappy.model.game.Game
import feup.ldts.flappy.model.game.Position
import feup.ldts.flappy.model.game.elements.Wall
import spock.lang.Specification

class GameControllerTest extends Specification{

    def "should increment score when player's x coordinate is two more than wall's x coordinate"(){
        given:
        Game game = new Game()
        GameController gameController = new GameController(game)
        Wall wall = new Wall(8)

        when:
        game.addWall(wall)
        wall.setPosition(new Position(1,1))
        game.getPlayer().setPosition(new Position(3,1))
        gameController.updateScore()

        then:
        game.getScore() == 1
    }

    def "should not increment score when player's x coordinate is one more than wall's x coordinate"(){
        given:
        Game game = new Game()
        GameController gameController = new GameController(game)
        Wall wall = new Wall(8)

        when:
        game.addWall(wall)
        wall.setPosition(new Position(1,1))
        game.getPlayer().setPosition(new Position(2,1))
        gameController.updateScore()

        then:
        game.getScore() == 0
    }
}
