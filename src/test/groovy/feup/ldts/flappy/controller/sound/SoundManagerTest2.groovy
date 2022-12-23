package feup.ldts.flappy.controller.sound

import spock.lang.Specification

class SoundManagerTest2 extends Specification {
    def 'Test playGodModeSound()'() {
        given:
        SoundManager soundManager = SoundManager.getInstance()

        when:
        soundManager.playGodModeSound()

        then:
        soundManager.gameBackgroundMusic.isRunning() == false
        soundManager.godModeSound.isRunning() == true
    }

    def 'Test stopGodModeSound()'() {
        given:
        SoundManager soundManager = SoundManager.getInstance()

        when:
        soundManager.stopGodModeSound()

        then:
        soundManager.gameBackgroundMusic.isRunning() == true
        soundManager.godModeSound.isRunning() == false
    }

    def 'Test stopAll()'() {
        given:
        SoundManager soundManager = SoundManager.getInstance()

        when:
        soundManager.stopAll()

        then:
        soundManager.menuBackgroundMusic.isRunning() == false
        soundManager.gameBackgroundMusic.isRunning() == false
        soundManager.godModeSound.isRunning() == false
    }

    def 'Test playGodModeSound()'() {
        given:
        SoundManager soundManager = SoundManager.getInstance()

        when:
        soundManager.playGodModeSound()

        then:
        soundManager.gameBackgroundMusic.isRunning() == false
        soundManager.godModeSound.isRunning() == true
    }

    def 'Test stopGodModeSound()'() {
        given:
        SoundManager soundManager = SoundManager.getInstance()

        when:
        soundManager.stopGodModeSound()

        then:
        soundManager.gameBackgroundMusic.isRunning() == true
        soundManager.godModeSound.isRunning() == false
    }

    def 'Test stopAll()'() {
        given:
        SoundManager soundManager = SoundManager.getInstance()

        when:
        soundManager.stopAll()

        then:
        soundManager.menuBackgroundMusic.isRunning() == false
        soundManager.gameBackgroundMusic.isRunning() == false
        soundManager.godModeSound.isRunning() == false
    }

    def 'Test playSoundEffect() with multiple effects'() {
        given:
        SoundManager soundManager = SoundManager.getInstance()

        when:
        soundManager.playSoundEffect(effect)

        then:
        soundManager."${propertie}".isRunning() == true

        where:
        effect                   | propertie
        SoundEffects.MENU_SELECT | 'selectEffectSound'
        SoundEffects.MENU_CHOICE | 'choiceEffectSound'
        SoundEffects.GAME_START  | 'startEffectSound'
        SoundEffects.GAME_OVER   | 'gameOverSound'
        SoundEffects.FLAP        | 'flapSound'
        SoundEffects.CONSUME     | 'consumeSound'
    }
}
