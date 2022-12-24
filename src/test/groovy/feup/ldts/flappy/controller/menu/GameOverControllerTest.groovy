package feup.ldts.flappy.controller.menu

import com.googlecode.lanterna.input.KeyStroke
import feup.ldts.flappy.model.menu.GameOver
import spock.lang.Specification



class GameOverControllerTest extends Specification {
    def "test update leaderboard with higher score than lowest score on leaderboard"() {
        given:
        def gameOver = new GameOver(100)
        gameOver.username = "test_user"
        GameOverController controller = new GameOverController(gameOver)

        File leaderboard = new File("src/main/resources/text/leaderboard.txt")
        FileWriter writer = new FileWriter(leaderboard)
        writer.write("99 - user1\n")
        writer.write("98 - user2\n")
        writer.write("97 - user3\n")
        writer.write("96 - user4\n")
        writer.write("95 - user5\n")
        writer.close()

        when:
        controller.updateLeaderboard()

        then:
        Scanner scanner = new Scanner(leaderboard)

        assert scanner.findWithinHorizon("100 - test_user", 0) != null
    }

    def "test doesnt update leaderboard with lower score than lowest score on leaderboard"() {
        given:
        def gameOver = new GameOver(90)
        gameOver.username = "test_user"
        GameOverController controller = new GameOverController(gameOver)

        File leaderboard = new File("src/main/resources/text/leaderboard.txt")
        FileWriter writer = new FileWriter(leaderboard)
        writer.write("99 - user1\n")
        writer.write("98 - user2\n")
        writer.write("97 - user3\n")
        writer.write("96 - user4\n")
        writer.write("95 - user5\n")
        writer.close()

        when:
        controller.updateLeaderboard()

        then:
        Scanner scanner = new Scanner(leaderboard)

        assert scanner.findWithinHorizon("90 - test_user", 0) == null
    }
    // Test if the username is updated correctly
    def "test update username"() {
        given:
        def gameOver = new GameOver(90)
        gameOver.username = ""
        GameOverController controller = new GameOverController(gameOver)

        Character character = 'a'
        Character character2 = 'b'
        KeyStroke key = new KeyStroke(character, false, false)
        KeyStroke key2 = new KeyStroke(character2, false, false)

        when:
        controller.charSelected(key)

        then:
        gameOver.username == "a"

        when:
        controller.charSelected(key2)

        then:
        gameOver.username == "ab"
    }
}