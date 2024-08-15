import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxNumber = 100;
        int maxAttempts = 5;
        int score = 0;

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(maxNumber) + 1;
            int attempts = 0;

            System.out.println("Guess a number between 1 and " + maxNumber);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String answer = scanner.next();
            playAgain = answer.equalsIgnoreCase("yes");
        }

        System.out.println("Your final score is: " + score);
    }
}
