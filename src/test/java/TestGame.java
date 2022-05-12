import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

import static org.junit.jupiter.api.Assertions.*;


public class TestGame {
    Player player = new Player(1, "PlayerName1", 2);
    Player player1 = new Player(2, "PlayerName2", 3);
    Player player2 = new Player(3, "PlayerName3", 1);
    Player player3 = new Player(4, "PlayerName4", 1);
    Game game = new Game();

    @Test
    void testPlayer1Win() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        assertEquals(1, game.round("PlayerName2", "PlayerName1"));
    }

    @Test
    void testPlayer2Win() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        assertEquals(2, game.round("PlayerName1", "PlayerName2"));
    }

    @Test
    void testNotRegisterPlayer1() {
        game.register(player);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("PlayerName4", "PlayerName1"));
    }

    @Test
    void testNotRegisterPlayer2() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("PlayerName1", "PlayerName4"));
    }

    @Test
    void testPlayer() {
        game.register(player);
        game.register(player1);
        game.register(player2);
        assertEquals(0, game.round("PlayerName2", "PlayerName2"));
    }

}
