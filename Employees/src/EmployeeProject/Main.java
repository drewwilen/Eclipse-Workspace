package EmployeeProject;

import java.util.*;

public class Main {

	static Scanner drew = new Scanner(System.in);// creates the scanner

	public static void main(String[] args) {

		ArrayList<Employee> workers = new ArrayList<Employee>();// creates the arraylist of employees and adds 3
																// existing employees to it (for initial workforce)
		workers.add(new FullTime("John Michaelson", 90000, 7, false));
		workers.add(new FullTime("Adam Jacobson", 80000, 5, true));
		workers.add(new PartTime("George Johnson", 20.50));

		int ans = 0;
		displayMenu();// shows you the menu of what your options are
		while (ans != 4) {
			ans = drew.nextInt();// allows u to chose what you want to do
			drew.nextLine();
			if (ans == 1) {// if ans is 1, shows all the workforce (which sorts the arraylist (itself))
				displayWorkers(workers);
			} else if (ans == 2) {// if you want to hire an employee, it asks you what type of employee you want
									// to hire
				System.out.println("Select Employee Type\n1)FullTime\n2)PartTime");
				int employeeAns = drew.nextInt();
				drew.nextLine();
				if (employeeAns == 1) {
					workers.add(createFullTime());
				} else if (employeeAns == 2) {
					workers.add(createPartTime());
				}
				System.out.println("Employee Hired.");
			} else if (ans == 3) {
				compareWorkers(workers);// allows you to compare two employees
			} else if (ans == 4) {
				break;// if you are done, it exits the loop
			} else {
				displayMenu();// if you enter an invalid ID, then you just see the menu again
			}
		}

	}

	public static void displayMenu() {// shows you the menu
		System.out.println("1)View employed workers\n2)Hire a new Employee\n3)Compare 2 workers salary\n4)Leave");

	}

	public static void displayWorkers(ArrayList<Employee> workers) {// Sorts the workers by yearly salary, and then
																	// displays them from low to high
		Collections.sort(workers);
		for (int i = 1; i <= workers.size(); i++) {
			System.out.println(i + ") " + workers.get(i - 1));
			System.out.println("-------------------------");
		}
	}

	public static Employee createPartTime() {// allows you to create a part time employee
		System.out.println("Enter name:");// lets you enter the name and salary to create the part time employee
		String name = drew.nextLine();
		System.out.println("Enter hourly salary:");
		double salary = drew.nextDouble();
		return new PartTime(name, salary);// returns the new employee
	}

	public static Employee createFullTime() {// allows you to create a full time employee
		System.out.println("Enter name:");// lets you enter the name, yearly salary, and benefits to create the full
											// time employee
		String name = drew.nextLine();
		System.out.println("Enter yearly salary:");
		double salary = drew.nextDouble();
		System.out.println("Enter Sick Days:");
		int sickDays = drew.nextInt();
		drew.nextLine();
		System.out.println("Do they have insurance?(y/n)");
		String ans = drew.nextLine();
		boolean insurance = false;
		if (ans.equals("y")) {
			insurance = true;
		}
		return new FullTime(name, salary, sickDays, insurance);// returns the new employee
	}

	public static void compareWorkers(ArrayList<Employee> workers) {
		Collections.sort(workers);// sorts the arraylist (to make sure it will be in the correct order)
		System.out.println("Enter Indexes of the workers you would like to compare");
		int e1 = drew.nextInt() - 1;// uses negative one because the list starts at 1
		drew.nextLine();
		int e2 = drew.nextInt() - 1;
		drew.nextLine();
		int comp = workers.get(e1).compareTo(workers.get(e2));// compares the workers, and then shows the result using a
																// printline
		if (comp == 0) {
			System.out.println(workers.get(e1).getName() + " and " + workers.get(e2).getName()
					+ " make the same amount of money.");
		}
		if (comp == 1) {
			System.out.println(workers.get(e1).getName() + " makes more money than " + workers.get(e2).getName());

		} else {
			System.out.println(workers.get(e1).getName() + " makes less money than " + workers.get(e2).getName());

		}
	}

}
