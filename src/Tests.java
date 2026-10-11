
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
     private final PrintStream originalOutput = System.out;

    @BeforeEach
    public void setupStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOutput);
    }

    @Test
    public void InputStop() {
        assertFalse(new Counter().addLine("stop"));
        assertFalse(new Counter().addLine("STOP"));
        assertFalse(new Counter().addLine("sToP"));
    }

    @Test
    public void InputNotStop() {
        assertTrue(new Counter().addLine(""));
        assertTrue(new Counter().addLine("abc"));
        assertTrue(new Counter().addLine(" stop"));
        assertTrue(new Counter().addLine("stop "));
        assertTrue(new Counter().addLine("\nstop"));
        assertTrue(new Counter().addLine("stop\n"));
    }

    @Test
    public void AddLine() {
        Counter counter = new Counter();

        assertEquals(0, counter.getLines());
        assertEquals(0, counter.getCharacters());
        assertEquals(0, counter.getWords());
        assertEquals("", counter.getLongestWord());

        counter.addLine("abc");

        assertEquals(1, counter.getLines());
        assertEquals(3, counter.getCharacters());
        assertEquals(1, counter.getWords());
        assertEquals("abc", counter.getLongestWord());
    }

    @Test
    public void PrintLine() {
        System.setIn(new ByteArrayInputStream("abc defgh ijkl\nstop".getBytes()));

        Input input = new Input();
        input.readUntilStop();
        assertEquals(
                """
                        lines: 1
                        characters: 14
                        words: 3
                        longest word: defgh
                        """, outputStream.toString());
    }
}
