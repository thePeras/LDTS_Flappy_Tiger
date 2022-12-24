package feup.ldts.flappy.model.game

import feup.ldts.flappy.gui.LanternaGUI
import feup.ldts.flappy.model.game.collectables.PortoWine
import feup.ldts.flappy.model.game.elements.Wall
import spock.lang.Specification

class GameTest extends Specification {
    def 'player should be initialized with the correct position'() {
        given:
        def gui = Mock(LanternaGUI)
        gui.height >> LanternaGUI.HEIGHT / 2 - 1

        when:
        def game = new Game()

        then:
        game.getPlayer().getPosition().getX() == 9
        game.getPlayer().getPosition().getY() == gui.height
    }

    def "getScore() should return the current score"() {
        given:
        Game game = new Game()
        expect:
        game.getScore() == 0
    }

    def "incrementScore() should set a new score"() {
        given:
        Game game = new Game()
        when:
        game.incrementScore(5)
        then:
        game.getScore() == 5
    }

    def "addWall() should add a wall to the game"() {
        given:
        Game game = new Game()
        Wall wall = new Wall(8)
        when:
        game.addWall(wall)
        then:
        game.getWalls().size() == 1
    }

    def "test that the incrementSteps method increments the steps field and resets it to 0 when it reaches 20"() {
        given:
        Game game = new Game()

        expect:
        game.getSteps() == 0

        when:
        for (int i = 0; i < 20; i++) {
            game.incrementSteps()
        }
        then:
        game.getSteps() == 0
    }


    def 'addCollectable method'() {
        given:
        def game = new Game()
        def collectable = new PortoWine(Mock(Position))

        when:
        game.addCollectable(collectable)

        then:
        game.getCollectables().size() == 1
        game.getCollectables().contains(collectable)
    }

    def "test that the startGodMode method sets the isInGodMode field to true, the godModeSteps field to 0, and updates the walls in the wallsList field"() {
        given:
        Game game = new Game()
        Wall wall = new Wall(9)
        game.addWall(wall)

        expect:
        !game.isInGodMode
        game.godModeSteps == 0
        wall.getSpace() == Wall.NORMAL_SPACE

        when:
        game.startGodMode()

        then:
        game.isInGodMode
        game.godModeSteps == 0
        wall.getSpace() == Game.GOD_MODE_WALL_SPACE
    }

    def "test that the incrementSteps method increments the godModeSteps field and sets the isInGodMode field to false when the godModeSteps field reaches the GOD_MODE_MAX_STEPS constant"() {
        given:
        Game game = new Game()
        game.isInGodMode = true
        game.godModeSteps = 0

        expect:
        game.isInGodMode
        game.godModeSteps == 0

        when:
        for (int i = 0; i < Game.GOD_MODE_MAX_STEPS; i++) {
            game.incrementSteps()
        }

        then:
        !game.isInGodMode
        game.godModeSteps == Game.GOD_MODE_MAX_STEPS
    }
}