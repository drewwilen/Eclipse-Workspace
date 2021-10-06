package lab1;

import java.util.*;

public class Searcher {

	static boolean sequentialSearch(String name, ArrayList<Student> classList) {//searches for a specific name using sequential search
		for (Student i : classList) {
			if (i.getName().toLowerCase().contains(name.toLowerCase())) {//goes through the list, searching each Student for that name
				return true;//returns whether or not that student is a student in the classList
			}
		}
		return false;
	}
	static boolean binarySearch(String name, ArrayList<Student> classList) {//searches for a specific name in a sorted list (by String) using binary search
		int high = classList.size()-1;
		int low = 0;
		while(low<=high) {//looks at the middle value and sees how it compares to the given name...
			int mid = (low + high)/2;//if it is higher in the alphabet, the second half of the list is ignored (by reducing the high value, if it is later in the alphabet, then the first half is ignored by increasing the low value 
			int comp = name.toLowerCase().compareTo(classList.get(mid).getName().toLowerCase());
			if(comp==0 || classList.get(mid).getName().toLowerCase().contains(name.toLowerCase())){//returns if it is in the list or not-allows you to also search by part of the name (first or last name)
				return true;
			}else if(comp > 0) {
				low = mid + 1;
			}else if(comp<0) {
				high = mid - 1;
			}
		}
		return false;
	}
}

