package codechallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringArrayIsArraySorted {

	public static void main(String[] args) {
		
//		String[] names = { "aa", "Ravi", "Manoj", "Arthy", "Karthick"}; 
		String[] names = { "aa", "arthy", "karthick", "manoj", "ravi"};
		
		//converting case and adding to List (ArrayList) 
		List<String> toStoreAndSort = new ArrayList<String>(); 
		
		for (String each : names) {
			toStoreAndSort.add(each.toLowerCase()); 
		}
		
		System.out.println("before sort " +toStoreAndSort); 
		Collections.sort(toStoreAndSort);
		System.out.println("after sort" + toStoreAndSort); 
		
		for (int i = 0; i < toStoreAndSort.size(); i++) {
			for (int j = 0; j< names.length; j++) {
				if (toStoreAndSort.get(i) == (names[j])) {
					System.out.print(names[j] + ", ");
				}
			}
		}
		
   if(toStoreAndSort.equals(names)) {
	 System.out.println("the array is sorted");
    }
   else {
	   System.err.println("array is not sorted");
   }

	}

}
