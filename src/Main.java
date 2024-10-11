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
                } else {
                    String Used_C = HM.getUsed_Chars().toString();
                    String Used_W = HM.getUsed_Words().toString();
                    int Wrong_A = HM.getWrong_Attempts();
                    int Attempts = HM.getAttempts();

                    if (!HM.LastAttempt) {

                        System.out.println("Incorrect!" +
                                "\nWrong Word: " + Guess +
                                "\nWrong Attempts: " + Wrong_A +
                                "\nTotal Attempts: " + Attempts);

                    }

                    if (!Used_C.isEmpty()) {
                        System.out.println("Used Characters: " + Used_C);
                    }
                    if (!Used_W.isEmpty()) {
                        System.out.println("Used Words: " + Used_W);
                    }

                    if (Wrong_A == 10) {
                        System.out.println("You've run out of attempts! The word was: " + HM.get_Target_Word());
                        break;
                    }
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