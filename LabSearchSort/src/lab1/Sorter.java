package lab1;
import java.util.*;
public class Sorter {

	static void swap(int i, int j, ArrayList<Student> classList) {//swap method-switches two items in an ArrayList
		Student temp = classList.get(j);
		classList.set(j, classList.get(i));
		classList.set(i, temp);
}
	
	
	static void selectionSort(ArrayList<Student> classList) {//selectionsort-sorts the arraylist by class rank-integer data member
		int pos = 0;
		int min = 0;
		for (int i = 0; i < classList.size(); i++) {//traverses arraylist and moves smallest class ranks and puts them at the beggining
			pos = i;
			min = classList.get(i).getClassRank();
			for(int j = i+1; j < classList.size(); j++) {//finds the smallest class rank throughout the rest of the arraylist, it gets swapped into that spot
				if(classList.get(j).getClassRank()<min) {
				min = classList.get(j).getClassRank();
				pos = j;
				}

			}		
			swap(i, pos, classList);//swaps the current spot w the smallest rank in the rest of the arraylist

		}	
	}
	static void insertionSort(ArrayList<Student> classList) {//sorts the arrayList by name (first name/letters)
		for (int i = 1; i < classList.size(); i++) {//goes through the arraylist from 1 to the end
			int temp = i;
			for (int j = i - 1; j >= 0; j--) {//goes through the arraylist, looking at the index 1 less than i, and checking if the name at i is alphabetically later the other one, if it is, it swaps the two and continutes
				if (classList.get(temp).getName().toLowerCase().compareTo(classList.get(j).getName().toLowerCase()) < 0) {

					swap(j, temp, classList);
					temp--;

				}
				else {
					break;
				}
			}
		}
	}
}
