package Day2;
import java.util.Scanner;

public class WordsSplit {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");

        String sentence = sc.nextLine();

        String[] words = sentence.split("\\s+"); 

        System.out.println("The words are:");

        for (String word : words) {
               System.out.println(word);
        }
    }
}
