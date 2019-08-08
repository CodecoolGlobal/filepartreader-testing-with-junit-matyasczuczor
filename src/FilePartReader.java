import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader(String filePath, Integer fromLine, Integer toLine) {
        filePath = null;
        fromLine = null;
        toLine = null;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 0) throw new IllegalArgumentException("not valid values");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("loremipsum.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    public String readLines() throws IOException {
        String[] file = read().split("\n");
        StringBuilder lines = new StringBuilder();
        for (int i = fromLine - 1; i < toLine; i++) {
            lines.append(file[i]);
        }
        return lines.toString();
    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public Integer getToLine() {
        return toLine;
    }
}
