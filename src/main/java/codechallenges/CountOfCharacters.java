package codechallenges;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

public class CountOfCharacters {

/*	public static void main(String[] args) {
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
*/

	@Test
	public void countofcharactersinString() {
		
		String input = "sathyajeyaraj"; 
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>(); 
		
		for (int i = 0; i < input.length(); i++) {
			int count = 0; 
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j) ) {
					count ++; 
				}
			}
			//inserting into Map for removing duplicate characters
			map.put(input.charAt(i), count);
		}
		
		for (Entry<Character, Integer>  character : map.entrySet()) {
			System.out.println(character.getKey() + "        " + character.getValue());
		}
		
		
	}
	
	
	
}