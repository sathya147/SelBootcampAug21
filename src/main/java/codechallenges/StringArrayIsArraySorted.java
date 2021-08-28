package codechallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringArrayIsArraySorted {

	public static void main(String[] args) {
		
		String[] names = {"Ravi", "Manoj", "Arthy", "Karthick"}; 
		
		//converting case and adding to List (ArrayList) 
		List<String> toStoreAndSort = new ArrayList<String>(); 
		
		for (String each : names) {
			toStoreAndSort.add(each.toLowerCase()); 
		}
		
		Collections.sort(toStoreAndSort);
//		System.out.println(toStoreAndSort); 
		
		for (int i = 0; i < toStoreAndSort.size(); i++) {
			for (int j = 0; j< names.length; j++) {
				if (toStoreAndSort.get(i).equalsIgnoreCase(names[j])) {
					System.out.print(names[j] + ", ");
				}
			}
		}
		


	}

}
