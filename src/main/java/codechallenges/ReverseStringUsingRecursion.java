package codechallenges;

public class ReverseStringUsingRecursion {

	public static void main(String[] args) {
//		reverse("sathya");
		justSubstring("sathya");

	}
	
	public static String reverse(String input) {   //the recursion part dint work
		int counter = 0; 
		System.out.println("input is now: " + input); 
		if (input.isEmpty()) {
			System.out.println("string is empty now");
			return input; 
		}
		counter++; 
		if (counter == 5) {
			input = ""; 
		}
		return reverse(input.substring(1) + input.charAt(0)); 
	}
	
	
	public static void justSubstring(String input) {
		try {
			String inputRev = ""; 
		for (int i = input.length(); i >= 1; i--) {
			System.out.println(i);
			inputRev = inputRev + input.charAt(i-1); 
			System.out.println(inputRev);
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	

}
