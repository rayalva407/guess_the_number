package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        int cpuGuess = rand.nextInt(21 + 1) + 1;
        String userName;
        int userGuess;
        int lives = 6;
        int numOfGuesses = 0;
        char playAgain;

	    System.out.println("Hello! What is your name?");
        userName = scnr.nextLine();
        System.out.println(String.format("Hello %s I'm thinking of a number between 1 and 20", userName));
        while (lives > 0) {
            System.out.println("Take a guess");
            userGuess = scnr.nextInt();
            scnr.nextLine();
            numOfGuesses++;
            if (userGuess != cpuGuess) {
                lives--;
                if (userGuess > cpuGuess) {
                    System.out.println("Your guess is too high");
                }
                if (userGuess < cpuGuess) {
                    System.out.println("Your guess is too low");
                }
            }
            if (userGuess == cpuGuess) {
                System.out.println(String.format("Good job %s! You guessed my number in %s guesses", userName, numOfGuesses));
                System.out.println("Would you like to play again? (y or n)");
                numOfGuesses = 0;
                playAgain = scnr.next().charAt(0);
                if (playAgain == 'y') {
                    lives = 6;
                    cpuGuess = rand.nextInt(21 + 1) + 1;
                }
                else {
                    System.out.println("Goodbye!");
                    return;
                }
            }
            if (lives == 0) {
                System.out.println("YOU LOSE!!! Maybe next time HAHA");
                System.out.println("Would you like to play again? (y or n)");
                numOfGuesses = 0;
                playAgain = scnr.next().charAt(0);
                if (playAgain == 'y') {
                    lives = 6;
                    cpuGuess = rand.nextInt(21 + 1) + 1;
                }
                System.out.println("Goodbye!");
            }
        }
    }
}
