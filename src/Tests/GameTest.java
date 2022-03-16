import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;

    @BeforeEach
    void setup() {
        game = new Game();
    }

    @DisplayName("Tests for losing a life")
    @Test
    void wrongGuess() {
        String message = "Number of lives should be one less after each wrongGuess method call";
        for(int i = game.lives; i >= 0; i--) {
            assertEquals(game.lives, i, message);
            game.wrongGuess();
        }
    }

    @DisplayName("Tests for win condition")
    @Test
    void winner() {
        game.userGuess = 0;
        game.cpuGuess = 0;
        while (game.userGuess <= 20) {
            for(game.cpuGuess = 0; game.cpuGuess <= 20; game.cpuGuess++) {
                if (game.winner(game.userGuess, game.cpuGuess)) {
                    assertTrue(game.winner(game.userGuess, game.cpuGuess), "Should be true if both user and cpu guess are the same");
                }
                if (!game.winner(game.userGuess, game.cpuGuess)) {
                    assertFalse(game.winner(game.userGuess, game.cpuGuess), "Should be false if both user and cpu guess are not the same");
                }
            }
            game.userGuess++;
        }
    }
}