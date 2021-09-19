package codechallenges;

import org.testng.annotations.Test;

public class Palindrome {

	//For String
	@Test
	public void findIfPalindrome() {

		String input = "madam";
		String inputReversed = "";

		for (int i = input.length() - 1; i >= 0; i--) {
			inputReversed = inputReversed + input.charAt(i);
		}

		if (input.equals(inputReversed)) {
			System.out.println(input + " is a palindrome");
			System.out.println(input + " = " + inputReversed);
		} else {
			System.out.println(input + " is not a palindrome");
			System.out.println(input + " != " + inputReversed);
		}

	}
	
	//For numbers
	@Test
	public void findIfPalindromeNumber() {

		int input = 543212345; 
		int workWithInput = input; 
		int revDigit; 
		int inputReversed = 0;

		while (workWithInput > 0) {
		revDigit = workWithInput % 10; 
		inputReversed = (inputReversed * 10) + revDigit; 
		workWithInput = workWithInput / 10; 
	    }

		if (input == inputReversed) {
			System.out.println(input + " is a palindrome");
			System.out.println(input + " = " + inputReversed);
		}
		else {
			System.out.println(input + " is not a palindrome");
			System.out.println(input + " != " + inputReversed);
		}
		System.out.println();
		


	}

}
