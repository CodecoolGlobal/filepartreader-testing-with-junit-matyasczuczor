import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testFromLineThrowsException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("lorepimpsum.txt", -1, 22));
    }

    @Test
    public void testToAndFromLineThrowsException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("loremipsum.txt", 20, 10));
    }

    @Test
    public void testReaderThrowsExeption() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("src/lloremipsum.txt", 0, 22);
        assertThrows(IOException.class, filePartReader::read);
    }


}