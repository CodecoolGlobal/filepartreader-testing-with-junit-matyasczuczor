import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testFromLineThrowsException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("lorepimpsum.txt",  0, 22));
    }

    @Test
    public void testToAndFromLineThrowsException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("loremipsum.txt", 20, 10));
    }

    @Test
    public void testReaderThrowsExeption() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/lloremipsum.txt", 1, 22);
        assertThrows(IOException.class, filePartReader::read);
    }

    @Test
    public void testWordsAlphabetically() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/loremipsumshort.txt", 1, 2);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        List expected = Arrays.asList("amet.", "dolor", "ipsum", "Lorem", "sit");
        assertEquals(expected, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testWordsContainingSubstring() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/loremipsumshort.txt", 1, 2);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        List expected = Arrays.asList("Lorem", "dolor");
        assertEquals(expected, fileWordAnalyzer.getWordsContainingSubstring("or"));
    }

    @Test
    public void testStringsWhichPalindromes() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/loremipsumshort.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        List expected = Arrays.asList("Racecar");
        assertEquals(expected, fileWordAnalyzer.getStringsWhichPalindromes());
    }
}