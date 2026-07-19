import java.util.Scanner;

public class Input {
    private final Counter counter = new Counter();

    void readUntilStop() {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            final var line = input.nextLine();

            if (!counter.addLine(line)) {
                IO.println("lines: %s".formatted(counter.getLines()));
                IO.println("characters: %s".formatted(counter.getCharacters()));
                IO.println("words: %s".formatted(counter.getWords()));
                IO.println("longest word: %s".formatted(counter.getLongestWord()));

                return;
            }
        }
    }
}
