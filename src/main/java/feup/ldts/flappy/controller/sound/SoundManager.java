package feup.ldts.flappy.controller.sound;

public class SoundManager {
    private static SoundManager INSTANCE = null;

    private final Sound menuBackgroundMusic;
    private final Sound gameBackgroundMusic;
    private final Sound selectEffectSound;
    private final Sound choiceEffectSound;
    private final Sound startEffectSound;
    private final Sound gameOverSound;
    private final Sound flapSound;
    private final Sound consumeSound;
    private final Sound godModeSound;

    private SoundManager() {
        this.menuBackgroundMusic = new Sound("src/main/resources/sounds/menu_background.wav");
        this.gameBackgroundMusic = new Sound("src/main/resources/sounds/game_background.wav");
        this.selectEffectSound = new Sound("src/main/resources/sounds/select_effect.wav");
        this.choiceEffectSound = new Sound("src/main/resources/sounds/choice_effect.wav");
        this.startEffectSound = new Sound("src/main/resources/sounds/start_effect.wav");
        this.gameOverSound = new Sound("src/main/resources/sounds/game_over_effect.wav");
        this.flapSound = new Sound("src/main/resources/sounds/flap_effect.wav");
        this.consumeSound = new Sound("src/main/resources/sounds/consume_effect.wav");
        this.godModeSound = new Sound("src/main/resources/sounds/god_mode_background.wav");

        this.menuBackgroundMusic.setVolume(0.05);
    }

    public static SoundManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SoundManager();
        }
        return INSTANCE;
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
    }

    public void pauseBackgroundSound() {
        gameBackgroundMusic.stop();
        godModeSound.stop();
    }

    public void resumeBackgroundSound() {
        gameBackgroundMusic.loop();
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
            case CONSUME:
                consumeSound.play();
                break;
        }
    }

    public void playGodModeSound() {
        pauseBackgroundSound();
        if (!godModeSound.isRunning()) {
            godModeSound.loop();
        }
    }

    public void stopGodModeSound() {
        godModeSound.stop();
        resumeBackgroundSound();
    }

    public void stopAll() {
        menuBackgroundMusic.stop();
        gameBackgroundMusic.stop();
        godModeSound.stop();
    }

    public void toggleSoundMute() {
        selectEffectSound.toggleMute();
        choiceEffectSound.toggleMute();
        startEffectSound.toggleMute();
        gameOverSound.toggleMute();
        flapSound.toggleMute();
        consumeSound.toggleMute();
        godModeSound.toggleMute();
    }

    public void toggleGameMusicMute() {
        gameBackgroundMusic.toggleMute();
        godModeSound.toggleMute();
    }

    public void toggleMenuMusicMute() {
        menuBackgroundMusic.toggleMute();
    }
}
