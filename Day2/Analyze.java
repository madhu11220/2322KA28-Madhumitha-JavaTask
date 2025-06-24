package Day2;
import java.util.Scanner;

public class Analyze {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String sentence = sc.nextLine().toLowerCase();

        String[] words = sentence.split("\\s+");

        int wordCount = words.length;
        int charCount = sentence.replaceAll("\\s+", "").length();

        String longestWord = getLongestWord(words);

        String[] reservedWords = {"public", "static", "void", "class", "int", "if", "else", "while"};

        int reservedWordCount = countReservedWords(words, reservedWords);

        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count (excluding spaces): " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Reserved Word Count: " + reservedWordCount);

      
    }

    static String getLongestWord(String[] words) {
        String longest = words[0];
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    static int countReservedWords(String[] words, String[] reservedWords) {
        int count = 0;
        for (String word : words) {
            for (String reserved : reservedWords) {
                if (word.equals(reserved)) {
                    count++;
                }
            }
        }
        return count;
    }
}


