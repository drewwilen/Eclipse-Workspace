package lab1;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner drew = new Scanner(System.in);
		ArrayList<Student> classList = new ArrayList<Student>();//creates the ArrayList of students (the class)-note, the order of the class is not equal to the order of the Arraylist
		classList.add(new Student("Kanye West", 6));//adds all the names and class ranks to the classList
		classList.add(new Student("Peter Parker", 1));
		classList.add(new Student("Bob Bobbert", 4));
		classList.add(new Student("Tony Stark", 2));
		classList.add(new Student("Pewdipie", 3));
		classList.add(new Student("Ninja", 5));

		System.out.println("Welcome to the schools digital Yearbook: \nEnter a name to perform a sequential search for a student. (You can search by First name, Last name, or full name)");
		String check = drew.nextLine();//allows you to search for a name/person in the class (sequentialsearch)
		boolean inClass = Searcher.sequentialSearch(check, classList);
		if (inClass) {
			System.out.println("There is a person named " + check + " in the class.");
		} else {//prints if they are in the class or not
			System.out.println("They are not the class.");
		}
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Now, allow me to show you the class in order of Class Rank");
		Sorter.selectionSort(classList);//sorts and prints the class in order of rank (one second between each member as to not print everything at the same time)
		for (Student s : classList) {
			TimeUnit.SECONDS.sleep(1);
			System.out.println(s);
		}

		System.out.println("Now you can add your name to the class. (Since you graduted last, your class Rank will be the lowest of the class).");
		String name = drew.nextLine();//asks for your name to add to the class
		int classRank = 7;
		Student s1 = new Student(name, classRank);
		classList.add(0, s1);//adds the new name to the ArrayList
		System.out.println("Now I will order the class alphabetically by first name.");

		Sorter.insertionSort(classList);//sorts and prints the class by name (first) with selectionsort (same delay)
		for (Student s : classList) {
			TimeUnit.SECONDS.sleep(1);
			System.out.println(s);
		}
		while (true) {//loop allows you to search for as many people as you want in the class (Binary Search)
			System.out.println("Would you like to search for someone by name?(y/n)");
			check = drew.nextLine();
			if (check.equals("y")) {
				System.out.println("Enter name: (You can search by First name, Last name, or Full name)");
				check = drew.nextLine();
				boolean studentInClass = Searcher.binarySearch(check, classList);//searches for that person
				if (studentInClass) {
					System.out.println("There is a person named " + check + " in the class.");
				} else {//prints if they are in the class or not
					System.out.println("They are not the class.");
				}
			} else {
				break;

			}
		}
		drew.close();//closes scanner

	}

}
