package feup.ldts.flappy.controller.sound

import spock.lang.Specification

class SoundManagerTest extends Specification{

    def soundManager = new SoundManager()

    def "getInstance()"() {
        expect:
        soundManager.getInstance() in SoundManager
    }

    def "getInstance() with same instance"() {
        when:
        def instance1 = soundManager.getInstance()
        def instance2 = soundManager.getInstance()

        then:
        instance1 == instance2
    }

    def 'not null sounds'(){
        expect:
        soundManager.menuBackgroundMusic != null;
        soundManager.gameBackgroundMusic != null;
        soundManager.selectEffectSound != null;
        soundManager.choiceEffectSound != null;
        soundManager.startEffectSound != null;
        soundManager.gameOverSound != null;
        soundManager.flapSound != null;
        soundManager.consumeSound != null;
        soundManager.godModeSound != null;

    }

    def 'Test setBackgroundSound()'(){
        given:
        SoundManager soundManager = SoundManager.getInstance()

        when:
        soundManager.setBackgroundSound(Musics.MENU_MUSIC)

        then:
        soundManager.menuBackgroundMusic.isRunning() == true
        soundManager.gameBackgroundMusic.isRunning() == false
    }

    def 'Test pauseBackgroundSound()'(){
        given:
        SoundManager soundManager = SoundManager.getInstance()

        when:
        soundManager.pauseBackgroundSound()

        then:
        soundManager.gameBackgroundMusic.isRunning() == false
        soundManager.godModeSound.isRunning() == false
    }

    def 'Test playGodModeSound()'(){
        given:
        SoundManager soundManager = SoundManager.getInstance()

        when:
        soundManager.playGodModeSound()

        then:
        soundManager.gameBackgroundMusic.isRunning() == false
        soundManager.godModeSound.isRunning() == true
    }

    def 'Test stopGodModeSound()'(){
        given:
        SoundManager soundManager = SoundManager.getInstance()

        when:
        soundManager.stopGodModeSound()

        then:
        soundManager.gameBackgroundMusic.isRunning() == true
        soundManager.godModeSound.isRunning() == false
    }

    def 'Test stopAll()'(){
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
        effect | propertie
        SoundEffects.MENU_SELECT | 'selectEffectSound'
        SoundEffects.MENU_CHOICE | 'choiceEffectSound'
        SoundEffects.GAME_START | 'startEffectSound'
        SoundEffects.GAME_OVER | 'gameOverSound'
        SoundEffects.FLAP | 'flapSound'
        SoundEffects.CONSUME | 'consumeSound'
    }
}
