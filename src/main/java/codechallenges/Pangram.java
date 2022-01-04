package codechallenges;

public class Pangram {
	//A Pangram is a sentence that contains every letter in the English alphabets. 

	public static void main(String[] args) {
//		isPangram("sathyajeyaraj walter sathya jeayraj walter sathya jeyaraj walter");
		isPangram("The quick brown fox jumps over the lazy dog");
	}
	
	public static void isPangram(String input) {
		Character cap = 65; 
		Character small = 97;
		if (input.length() >= 26 ) {
			for (int i = 1; i <=26; i++) {
				if (input.contains(cap.toString()) || input.contains(small.toString()) ) {
					if (i == 26) {
						System.out.println("input is a PANGRAM");
					}
					
				}
				else {
					System.out.println("input is not Pangram");
					break; 
				}
				cap++; 
				small++; 
			}
		}
		else {
			System.out.println("size - input is not Pangram");
		}

	System.out.println("end of program");
	}

}
