package codechallenges;

public class IntReverseTheIntValue {

	public static void main(String[] args) {
		
		int input = 90807; 
		System.out.println("integer given to reverse: " +input);
		int balance = 0, holder = 0; 
		
		while (input != 0) {
			balance = input % 10;
			holder = holder * 10 + balance; 
			input = input / 10; 
		}
		System.out.println("reversed integer: " +holder);
	}

}
