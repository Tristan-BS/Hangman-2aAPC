import java.util.ArrayList;

public class Hangman {
    private String Word;
    private String Hidden_Word;
    private String Hint;
    private final ArrayList<String> Used_Chars = new ArrayList<String>();
    private final ArrayList<String> Used_Words = new ArrayList<String>();

    public boolean Guess_Taken(String Guess) {
        Guess = Guess.toUpperCase();

        if (Guess.length() > 1) {
            if (Guess.equals(Word)) {
                return true;

            } else if (!Guess.matches("[A-Z]+")) { // Only allow single alphabetic characters
                System.out.println("Invalid Input! \nOnly single alphabetic characters are allowed! \n");
                return false;

            } else {
                Used_Words.add(Guess);
                System.out.println("\nIncorrect! Wrong Word: " + Guess
                        + "\nAlready used letters: " + Used_Chars
                        + "\nAlready used words: " + Used_Words
                        + "\n");
                return false;
            }

        } else if (!Guess.matches("[A-Z]")) { // Only allow single alphabetic characters
            System.out.println("Invalid Input! \nOnly single alphabetic characters are allowed! \n");
            return false;
        }

        if (Used_Chars.contains(Guess)) {
            System.out.println("You've already guessed that letter.");
            return false;
        }

        if (Word.contains(Guess)) {
            // Replace the _ with the guessed letter
            for (int i = 0; i < Word.length(); i++) {
                if (Word.charAt(i) == Guess.charAt(0)) {
                    Hidden_Word = Hidden_Word.substring(0, i) + Guess + Hidden_Word.substring(i + 1);
                }
            }
            System.out.println(Hidden_Word);
        } else {
            Used_Chars.add(Guess);
            System.out.println("\nIncorrect! Wrong Letter: " + Guess
                    + "\nAlready used letters: " + Used_Chars
                    + "\nAlready used words: " + Used_Words
                    + "\n");
            return false;
        }

        return Hidden_Word.equals(Word);
    }

    public String get_Target_Word() {
        Word = WordList.getRandomWord();
        return Word;
    }

    public String get_Hidden_Word() {
        Hidden_Word = "";

        for (int i = 0; i < Word.length(); i++) {
            if (Word.charAt(i) == ' ') {
                Hidden_Word += " ";
            } else {
                Hidden_Word += "_";
            }
        }
        return Hidden_Word;
    }
}