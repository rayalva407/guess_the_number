import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scnr = new Scanner(System.in);
    Random rand = new Random();
    int cpuGuess = rand.nextInt(21 + 1) + 1;
    String userName;
    int userGuess = 0;
    int lives = 6;
    int numOfGuesses = 0;
    char playAgain;

    void getName() {
        System.out.println("Hello! What is your name?");
        userName = scnr.nextLine();
    }

    void makeGuess() {
        try {
            userGuess = scnr.nextInt();
            scnr.nextLine();
            numOfGuesses++;
        }
        catch (Exception e) {
            System.out.println("WRONG INPUT! Please enter a number from 1 - 20");
            scnr.next();
            makeGuess();
        }
    }

    void wrongGuess() {
        lives--;
        if (userGuess > cpuGuess) {
            System.out.println("Your guess is too high");
        }
        if (userGuess < cpuGuess) {
            System.out.println("Your guess is too low");
        }
    }

    void newGame() {
        System.out.println("Would you like to play again? (y or n)");
        numOfGuesses = 0;
        playAgain = scnr.next().charAt(0);
        if (playAgain == 'y') {
            lives = 6;
            cpuGuess = rand.nextInt(21 + 1) + 1;
        }
        else if(playAgain == 'n') {
            lives = 0;
            System.out.println("Thanks for playing! Goodbye!");
        }
        else {
            System.out.println("WRONG INPUT! Please choose y or n");
            newGame();
        }
    }

    boolean winner(int userGuess, int cpuGuess) {
        return userGuess == cpuGuess;
    }
}
