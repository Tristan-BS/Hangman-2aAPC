import java.util.Scanner;

public class Main {
    public static String Guess;
    public static boolean Returned_Value;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Hangman HM = new Hangman();
            System.out.println("Welcome to Hangman!");

            System.out.println(HM.get_Target_Word());
            System.out.println(HM.get_Hidden_Word());

            while (true) {
                System.out.println("Choose a letter: ");
                Guess = scanner.nextLine();

                Returned_Value = HM.Guess_Taken(Guess);

                if (Returned_Value) {
                    System.out.println("Congratulations! You've guessed the word!");
                    break;
                }
            }

            System.out.println("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
}