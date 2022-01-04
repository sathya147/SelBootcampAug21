package codechallenges;

public class Anagram {

	public static void main(String[] args) {
		isAnagram("teas", "esta");

	}

	public static void isAnagram(String input1, String input2) {
		
		if (input1.length() == input2.length()) {

				for (int i = 0; i < input1.length(); i++) {
					if (input2.contains(Character.toString(input1.charAt(i))) ) {
						if (i == input1.length()-1) {
							System.out.println("Inputs are Anagram");
						}
					}
					else {
						System.out.println("inputs are not Anagram - in");
						break; 
					}
				}
		}
		else {
			System.out.println("inputs are not Anagram");
		}
		System.out.println("end of program");
	}
}
