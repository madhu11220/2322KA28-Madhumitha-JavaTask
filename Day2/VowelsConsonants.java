package Day2;

import java.util.Scanner;

public class VowelsConsonants {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a string:");

		String str = sc.nextLine().toLowerCase();

		int vowels = 0;

		int consonants = 0;

		for(char c : str.toCharArray()) {
 {

		if(c >= 'a' && c <= 'z') {

		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u') {

		vowels++;

		} else {

		consonants++;

		}

		}

		}

		System.out.println("Vowels:" +vowels);

		System.out.println("Consonants:" +consonants);

		}

	}
}

