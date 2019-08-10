import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) throw new IllegalArgumentException("not valid values");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
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

    public String readLines() {
        StringBuilder lines = new StringBuilder();
        try {
            String[] file = read().split("\n");
            for (int i = fromLine - 1; i < toLine; i++) {
                lines.append(file[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines.toString();
    }
}
