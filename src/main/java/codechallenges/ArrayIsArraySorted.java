package codechallenges;

import java.util.Arrays;

public class ArrayIsArraySorted {

	public static void main(String[] args) {
		
		
/*		//Type 1 - using for loop
		int[] numbers = {4, -7, 8, 10};

		if (numbers == null) {
			System.out.println("array is empty");
		}
		else if (numbers.length <= 1) {
			System.out.println("true");
		}
		else {
			for (int i = 0; i < numbers.length - 1; i++) {
				if (numbers[i] > numbers[i+1]) {
					System.out.println("false");
					break;
				}
				else if (i == numbers.length - 2) {
					System.out.println("true");
				}
			}
		}
*/
		
/*		//Type 2 - using java's inbuilt function sort()
		
		int[] numbers = {4, 8, -9, 23}; 
		int[] sorted = numbers.clone(); 
	
		Arrays.sort(sorted);
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(sorted));
		
		if (Arrays.equals(numbers, sorted)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
*/
		int[] numbers = {4, 8, 10}; 
		System.out.println(verifySort(numbers)); 
		
	}
	
	//Type 3 - others checking 
		public static String verifySort(int[] a) {
			if (a == null || a.length <= 1) {
				return "empty array"; 
			}
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i+1]) {
					return "false"; 
				}
			}
			return "true"; 
	
		}
	
}
