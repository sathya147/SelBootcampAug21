package codechallenges;

import java.util.LinkedHashSet;
import java.util.Set;

public class CountOfCharacters {

	public static void main(String[] args) {
		String input = "TESTLEAF";

		// storing in set to ignore duplicates
		Set<Character> storeset = new LinkedHashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			storeset.add(input.charAt(i));
		}
		System.out.println(storeset);

		// counting unique characters only and printing
		for (Character each : storeset) {
			char charBase =  each; 
			int countChar = 0;
			for (int j = 0; j < input.length(); j++) {
				char charCompare = input.charAt(j);
				if (charBase == charCompare) {
					countChar = countChar + 1;
				}
			}
			System.out.println(each + " is available " + countChar + " times in the given string");
		}
		System.out.println("end");
	}

}