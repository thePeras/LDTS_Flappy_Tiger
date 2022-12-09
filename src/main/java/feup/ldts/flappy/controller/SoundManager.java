package feup.ldts.flappy.controller;

import feup.ldts.flappy.model.sound.Musics;
import feup.ldts.flappy.model.sound.Sound;
import feup.ldts.flappy.model.sound.SoundEffects;

public class SoundManager {
    private static SoundManager instance = null;

    private Sound menuBackgroundMusic;
    private Sound gameBackgroundMusic;
    private Sound selectEffectSound;
    private Sound choiceEffectSound;
    private Sound startEffectSound;
    private Sound gameOverSound;
    private Sound flapSound;

    private SoundManager() {
        this.menuBackgroundMusic = new Sound("src/main/resources/sounds/menu_background.wav");
        this.gameBackgroundMusic = new Sound("src/main/resources/sounds/game_background.wav");
        this.selectEffectSound = new Sound("src/main/resources/sounds/select_effect.wav");
        this.choiceEffectSound = new Sound("src/main/resources/sounds/choice_effect.wav");
        this.startEffectSound = new Sound("src/main/resources/sounds/start_effect.wav");
        this.gameOverSound = new Sound("src/main/resources/sounds/game_over_effect.wav");
        this.flapSound = new Sound("src/main/resources/sounds/flap_effect.wav");
    }

    public static SoundManager getInstance() {
        if (instance == null) {
            instance = new SoundManager();
        }
        return instance;
    }

    public void setBackgroundSound(Musics music) {
        switch (music) {
            case MENU_MUSIC:
                gameBackgroundMusic.stop();
                menuBackgroundMusic.loop();
                break;
            case GAME_MUSIC:
                menuBackgroundMusic.stop();
                gameBackgroundMusic.loop();
                break;
        }
        menuBackgroundMusic.setVolume(0.05);
    }
    public void pauseBackgroundSound() {
        gameBackgroundMusic.stop();
    }
    public void resumeBackgroundSound(){
        gameBackgroundMusic.resume();
    }
    public void playSoundEffect(SoundEffects effect) {
        switch (effect) {
            case MENU_SELECT:
                selectEffectSound.play();
                break;
            case MENU_CHOICE:
                choiceEffectSound.play();
                break;
            case GAME_START:
                startEffectSound.play();
                break;
            case GAME_OVER:
                gameOverSound.play();
                break;
            case FLAP:
                flapSound.play();
                break;
        }
    }
    public void stopAll() {
        menuBackgroundMusic.stop();
        gameBackgroundMusic.stop();
    }
}
