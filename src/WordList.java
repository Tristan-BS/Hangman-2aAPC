import java.util.Random;

public enum WordList {
    QUENTIN,
    TISCH,
    MONITOR,
    APPLIKATIONSENTWICKLER,
    MOTORRAD,
    BAUMHAUS,
    KNAPP_AG,
    VERFLUCHT,
    BERUFSSCHULE,
    PARKPLATZ;

    public static String getRandomWord() {
        WordList[] words = WordList.values(); // Get all the words from the enum
        Random rand = new Random();
        return words[rand.nextInt(words.length)].name(); // Return a random word -> words[0] = QUENTIN, words[1] = TISCH, ...
    }
}