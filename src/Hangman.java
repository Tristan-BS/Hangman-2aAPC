import java.util.ArrayList;

public class Hangman {
    private String Word;
    private String Hidden_Word;
    private int Wrong_Attempts = 0;
    private int Attempts = 0;

    public boolean LastAttempt;

    private final ArrayList<String> Used_Chars = new ArrayList<>();
    private final ArrayList<String> Used_Words = new ArrayList<>();

    public boolean Guess_Taken(String Guess) {
        Guess = Guess.toUpperCase();
        Attempts += 1;

        if (Used_Chars.contains(Guess)) {
            System.out.println("You've already guessed that letter.");
            Attempts += 1;
            System.out.println("\n" + Hidden_Word + "\n");
            return false;
        } else {

            if (Guess.length() > 1) {
                if (Guess.equals(Word)) {
                    return false;

                } else if (!Guess.matches("[A-Z]+")) { // Only allow single alphabetic characters
                    System.out.println("Invalid Input! \nOnly single alphabetic characters are allowed! \n");
                    Wrong_Attempts += 1;
                    System.out.println("\n" + Hidden_Word + "\n");
                    return false;

                } else {
                    Used_Words.add(Guess);
                    Wrong_Attempts += 1;
                    System.out.println("\n" + Hidden_Word + "\n");
                    return false;
                }

            } else if (!Guess.matches("[A-Z]")) { // Only allow single alphabetic characters
                System.out.println("Invalid Input! \nOnly single alphabetic characters are allowed! \n");
                Wrong_Attempts += 1;
                System.out.println("\n" + Hidden_Word + "\n");
                return false;
            }

            Used_Chars.add(Guess);
            if (Word.contains(Guess)) {
                for (int i = 0; i < Word.length(); i++) {
                    if (Word.charAt(i) == Guess.charAt(0)) {
                        Hidden_Word = Hidden_Word.substring(0, i) + Guess + Hidden_Word.substring(i + 1); // Replace _ -> correct word
                    }
                }
                LastAttempt = true;
                System.out.println("\n" + Hidden_Word + "\n");
            } else {
                Wrong_Attempts += 1;
                System.out.println("\n" + Hidden_Word + "\n");
                LastAttempt = false;
                return false;
            }
        }
        return Hidden_Word.equals(Word);
    }

    public String get_Target_Word() {
        Word = WordList.getRandomWord();
        return Word;
    }

    public String get_Hidden_Word() {
        Hidden_Word = "";

        // Replace _ from the original word with spaces

        for (int i = 0; i < Word.length(); i++) {
            if (Word.charAt(i) == ' ') {
                Hidden_Word += " ";
            } else {
                Hidden_Word += "_";
            }
        }
        return Hidden_Word;
    }

    // Getter

    public ArrayList<String> getUsed_Chars() {
        return Used_Chars;
    }
    public ArrayList<String> getUsed_Words() {
        return Used_Words;
    }
    public int getWrong_Attempts() {
        return Wrong_Attempts;
    }
    public int getAttempts() {
        return Attempts;
    }
}