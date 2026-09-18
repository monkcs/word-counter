import java.util.Arrays;
import java.util.Comparator;

public class Counter {

    boolean addLine(String line) {
        if (line.equalsIgnoreCase("stop")) {
            return false;
        }

        lines += 1;
        characters += line.length();

        var rawLineWords = line.split(" ");
        Arrays.sort(rawLineWords, Comparator.comparingInt(String::length));

        final var lineWords = Arrays.stream(rawLineWords).filter(s -> !s.isEmpty()).toArray(String[]::new);

        if (lineWords.length != 0) {
            words += lineWords.length;

            final var longestLineWord = lineWords[lineWords.length - 1];
            if (longestWord.length() <= longestLineWord.length()) {
                longestWord = longestLineWord;
            }
        }

        return true;
    }

    int getLines() {  return lines; }
    int getCharacters() { return characters; }
    int getWords() { return words; }
    String getLongestWord() { return longestWord; }

    private int lines = 0;
    private int characters = 0;
    private int words = 0;
    private String longestWord = "";
}
