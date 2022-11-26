package feup.ldts.flappy.controller;

import feup.ldts.flappy.controller.game.PlayerController;
import feup.ldts.flappy.gui.GUI;
import feup.ldts.flappy.model.game.Game;
import feup.ldts.flappy.model.game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {
    private PlayerController playerController;
    private Game game;
    private Player player;

    @BeforeEach
    public void setUp() {
        game = new Game();
        player = game.getPlayer();
        playerController = new PlayerController(game);
    }

    @Test
    public void testJumpPlayer() {
        playerController.jumpPlayer();
        assertEquals(-3, player.getVelocity());
    }

    @Test
    public void testUpdatePosition() {
        assertEquals(14, player.getPosition().getY());
        assertEquals(1, player.getVelocity());

        playerController.updatePosition();
        assertEquals(13, player.getPosition().getY());
        assertEquals(-1, player.getVelocity());

        game.setPlaying(true);

        playerController.updatePosition();
        assertEquals(0, player.getVelocity());

        assertEquals(12, player.getPosition().getY());
        playerController.updatePosition();
        assertEquals(12, player.getPosition().getY());

        playerController.jumpPlayer();
        assertEquals(-3, player.getVelocity());
        playerController.updatePosition();
        assertEquals(-2, player.getVelocity());
        assertEquals(9, player.getPosition().getY());
    }

    @Test
    public void jumpStartPlaying(){
        assertEquals(false, game.isPlaying());
        playerController.jumpPlayer();
        assertEquals(true, game.isPlaying());
    }

    @Test
    public void testStep() {
        assertEquals(1, player.getVelocity());
        playerController.step(null, GUI.ACTION.JUMP);
        assertEquals(-3, player.getVelocity());
    }
}
