import java.util.Scanner;

public class Input {
    private final Counter counter = new Counter();

    void readUntilStop() {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            final var line = input.nextLine();

            if (!counter.addLine(line)) {
                IO.println("lines: " + counter.getLines());
                IO.println("characters: " + counter.getCharacters());
                IO.println("words: " + counter.getWords());
                IO.println("longest word: " + counter.getLongestWord());

                return;
            }
        }
    }
}
