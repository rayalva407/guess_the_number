public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        game.getName();
        System.out.println("Hello " + game.userName + " I'm thinking of a number between 1 and 20");

        while (game.lives > 0) {
            System.out.println("Take a guess");
            game.makeGuess();

            if (!game.winner(game.userGuess, game.cpuGuess)) {
                game.wrongGuess();
            }
            if (game.lives == 0) {
                System.out.println("YOU LOSE!!! Maybe next time HAHA");
                game.newGame();
            }
            if (game.winner(game.userGuess, game.cpuGuess)) {
                System.out.println("Good job " + game.userName + "! You guessed my number in " + game.numOfGuesses + " guesses");
                game.newGame();
            }
        }
    }
}
