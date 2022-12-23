package feup.ldts.flappy.model.menu

import feup.ldts.flappy.gui.LanternaGUI
import spock.lang.Specification

class GameOverTest extends Specification {
    def "getUsername and getScore return the username and the score correctly"() {
        given:
        def gameOver = new GameOver(10)
        gameOver.username = "test_user"
        expect:
        gameOver.getUsername() == "test_user"
        gameOver.getScore() == 10
    }
    def "test addChar respects maximum length"() {
        given:
        GameOver gameOver = new GameOver(0)

        when:
        for (int i = 0; i < LanternaGUI.WIDTH - 2 * GameOver.MARGIN; i++) {
            Character character = 'a'
            gameOver.addChar(character)
        }
        Character characterB = 'b'
        gameOver.addChar(characterB)

        then:
        gameOver.username.length() == LanternaGUI.WIDTH - 2 * GameOver.MARGIN
        gameOver.username.charAt(LanternaGUI.WIDTH - 2 * GameOver.MARGIN - 1) == 'a'
    }
    def "test removeChar"(){
        given:
        GameOver gameOver = new GameOver(0)
        gameOver.username = "test_user"

        when:
        gameOver.removeChar()

        then:
        gameOver.username == "test_use"
    }
}
