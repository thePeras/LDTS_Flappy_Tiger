package feup.ldts.flappy.model.menu

import spock.lang.Specification

class GameOverTest extends Specification{
    def "getUsername and getScore return the username and the score correctly"() {
        given:
        def gameOver = new GameOver(10)
        gameOver.username = "test_user"
        expect:
        gameOver.getUsername() == "test_user"
        gameOver.getScore() == 10
    }
}
