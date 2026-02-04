import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int guess = 0;

        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100");

        while (guess != numberToGuess) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct!");
                System.out.println("Attempts: " + attempts);
            }
        }

        sc.close();
    }
}
