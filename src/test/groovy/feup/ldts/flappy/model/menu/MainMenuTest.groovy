package feup.ldts.flappy.model.menu

import spock.lang.Specification


class MainMenuTest extends Specification {
    def "fillCuriosity should read a file and populate the curiosity property"() {
        given:
        MainMenu mainMenu = new MainMenu()
        when:
        mainMenu.fillCuriosity()
        then:
        mainMenu.curiosity != null
    }
    def "nextOption should move to the next option in the list"() {
        given:
        def menu = new MainMenu()
        menu.options = ['Option 1', 'Option 2', 'Option 3']
        menu.option = 0

        when:
        menu.nextOption()

        then:
        menu.option == 1

        when:
        menu.nextOption()

        then:
        menu.option == 2

        when:
        menu.nextOption()

        then:
        menu.option == 0
    }

    def "previousOption should move to the previous option in the list"() {
        given:
        def menu = new MainMenu()
        menu.options = ['Option 1', 'Option 2', 'Option 3']
        menu.option = 2

        when:
        menu.previousOption()

        then:
        menu.option == 1

        when:
        menu.previousOption()

        then:
        menu.option == 0

        when:
        menu.previousOption()

        then:
        menu.option == 2
    }
    def "Test isSelected()"(){
        given:
        def menu = new MainMenu()
        menu.options = ['Option 1', 'Option 2', 'Option 3']
        menu.option = 2

        when:
        menu.isSelected(2)

        then:
        menu.isSelected(2) == true

        when:
        menu.isSelected(1)

        then:
        menu.isSelected(1) == false
    }
}

