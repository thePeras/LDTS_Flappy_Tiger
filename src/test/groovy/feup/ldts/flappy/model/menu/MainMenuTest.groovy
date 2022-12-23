package feup.ldts.flappy.model.menu

import spock.lang.Specification


class MainMenuTest extends Specification{
    def "fillCuriosity should read a file and populate the curiosity property"() {
        given:
        MainMenu mainMenu = new MainMenu()
        when:
        mainMenu.fillCuriosity()
        then:
        mainMenu.curiosity != null
    }
}
