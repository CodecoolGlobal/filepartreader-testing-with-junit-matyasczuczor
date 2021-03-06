import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public ArrayList getWordsOrderedAlphabetically() {
        String text = filePartReader.readLines();
        ArrayList<String> wordsOrdered = new ArrayList<>();
        Collections.addAll(wordsOrdered, text.split(" "));
        wordsOrdered.sort(String::compareToIgnoreCase);
        return wordsOrdered;
    }

    public List getWordsContainingSubstring(String subString) {
        String text = filePartReader.readLines();
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, text.split(" "));
        ArrayList<String> matchedWords = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().contains(subString)) {
                matchedWords.add(word);
            }
        }
        return matchedWords;
    }

    public List getStringsWhichPalindromes() {
        String text = filePartReader.readLines();
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, text.split(" "));
        ArrayList<String> palindromes = new ArrayList<>();
        for (String word : words) {
            if (isPalindrome(word)) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    private boolean isPalindrome(String word) {
        int i1 = 0;
        int i2 = word.length() - 1;
        while (i2 > i1) {
            if (word.toLowerCase().charAt(i1) != word.toLowerCase().charAt(i2)) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }
}
