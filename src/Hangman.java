import java.util.ArrayList;

public class Hangman {
    private String Word;
    private String Hidden_Word;
    private String Hint;
    private String Guessed_Char;
    private ArrayList<String> Used_Chars = new ArrayList<String>();

    public boolean Guess_Taken(String Guess) {
        if (Used_Chars.contains(Guess)) {
            System.out.println("You've already guessed that letter.");
            return false;
        } else {
            Guess = Guess.toUpperCase();

            if (Guess.length() > 1) {
                if (Guess.equals(Word)) {
                    return true;
                } else {
                    System.out.println("Incorrect! Wrong Word: " + Guess);
                    return false;
                }
            } else if(Guess.matches(".*\\d.*") || Guess.matches(".*[!@#$%^&*()].*")) {
                System.out.println("Invalid input! Please enter a letter.");
                return false;
            }

            Used_Chars.add(Guess);

            if (Word.contains(Guess)) {
                // Replace the _ with the guessed letter
                for (int i = 0; i < Word.length(); i++) {
                    if (Word.charAt(i) == Guess.charAt(0)) {
                        Hidden_Word = Hidden_Word.substring(0, i) + Guess + Hidden_Word.substring(i + 1);
                    }
                }
                System.out.println(Hidden_Word);
            } else {
                System.out.println("Incorrect! Wrong Letter: " + Guess);
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