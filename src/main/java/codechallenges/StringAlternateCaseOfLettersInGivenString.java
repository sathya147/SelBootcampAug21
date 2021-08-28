package codechallenges;

public class StringAlternateCaseOfLettersInGivenString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
/*		//Type 1 - using char[] and printing as we convert
		String input = "Java"; 
			
		char[] charArray = input.toCharArray(); 
		
		for (Character each : charArray) {
			if (Character.isLowerCase(each)) {
				System.out.print(each.toString().toUpperCase());
				//System.out.println(each);
			}
			else {
				System.out.print(each.toString().toLowerCase());
				//System.out.println(each);
			}
		}
	}
*/
		
		
/*		//Type 2 - directly converting from String using charAt[index] (a method of String class) and printing as we convert
		String input = "Java"; 
		
		//trying to convert to char array
		
		for (int i = 0; i < input.length(); i++) {
			if (Character.isLowerCase(input.charAt(i))) {
				System.out.print(Character.toUpperCase(input.charAt(i)));
			}
			else {
				System.out.print(Character.toLowerCase(input.charAt(i)));
			}
			
		}
		
	}
*/

		
/*		//Type 3 - converting using Type 2 and storing into StringBuffer and displaying
		String input = "Java"; 
		StringBuffer strbuf = new StringBuffer(input); 
		
		for (int i = 0; i < input.length(); i++) {
			if (Character.isLowerCase(input.charAt(i))) {
				strbuf.setCharAt(i, Character.toUpperCase(input.charAt(i)));
			}
			else {
				strbuf.setCharAt(i, Character.toLowerCase(input.charAt(i)));
			}
			
		}
		
		System.out.println(strbuf);
		
	}
*/		
		
		//Type 4 - By comparing to asci character value and adding or subtracting 32 to the character's value
		String input = "Java"; 
		int num; 
		char c; 
		String output = ""; 
		
		for (int i = 0; i < input.length(); i++) {
			c = input.charAt(i); 
			if (c >= 65 && c <= 90) {
				c = (char) (c + 32); 
			}
			else {
				c = (char) (c - 32); 
			}
			
			output = output + c; 
			
		}
		
		System.out.println(output);
		
	}

}
