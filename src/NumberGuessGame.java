import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String playAgain;

        do {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            Integer guess = null;

            System.out.println("Welcome to Number Guessing Game!");
            System.out.println("Guess a number between 1 and 100");

            while (guess == null || guess != numberToGuess) {
                System.out.print("Enter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next(); // discard wrong input
                    continue;
                }

                guess = sc.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct!");
                    System.out.println("Attempts taken: " + attempts);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        sc.close();
        System.out.println("Thanks for playing!");
    }
}
