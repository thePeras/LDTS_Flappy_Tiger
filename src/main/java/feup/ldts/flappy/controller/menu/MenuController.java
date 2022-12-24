package feup.ldts.flappy.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import feup.ldts.flappy.App;
import feup.ldts.flappy.controller.Controller;
import feup.ldts.flappy.controller.sound.SoundEffects;
import feup.ldts.flappy.controller.sound.SoundManager;
import feup.ldts.flappy.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class MenuController<T extends Menu> extends Controller<T> implements MenuInterface {
    public MenuController(T model) {
        super(model);
    }

    @Override
    public void step(App game, KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        if (key == null) return;
        if (key.getKeyType() == KeyType.ArrowUp) {
            getModel().previousOption();
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            getModel().nextOption();
        }
        if (key.getKeyType() == KeyType.Enter) {
            SoundManager.getInstance().playSoundEffect(SoundEffects.MENU_CHOICE);
            optionSelected(game);
        }
        if (key.getKeyType() == KeyType.Character) {
            if (key.getCharacter() == null) return;
            charSelected(key);
        }
        if (key.getKeyType() == KeyType.Escape) {
            escapePressed(game);
        }
        if (key.getKeyType() == KeyType.Backspace) {
            backspacePressed(game);
        }
    }

    public void charSelected(KeyStroke key) {
        if (key.getCharacter() == 'm') {
            SoundManager.getInstance().toggleMenuMusicMute();
        }
        if (key.getCharacter() == 's') {
            SoundManager.getInstance().toggleSoundMute();
        }
    }
}
