package ErrorsExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		System.out.println("It begins");
		/*
		 * Part 1 - Try-Catch
		 * 
		 * Using a Try-Catch, fix the part1() method to be able to maintain control and
		 * continue after the user enters non-int values (decimals/characters).
		 */
		// part1();

		/*----------------------------------------------
		 * Part 2 - Try-Catch-Finally
		 * 
		 * Handle the exception thrown by part2() for the file not being in the
		 * directory. Also makes sure that the code continues if there are non-int
		 * values in the text file. Be sure to handle the cleanup code necessary for
		 * dealing with a Scanner.
		 */

		// part2();

		/*----------------------------------------------
		 * Part 3 - Exception Propagation
		 * There are exceptions being thrown by part3C() and part3D(). 
		 * Catch and deal with the exceptions outside of part3C() part3D()
		 * but before it reaches the main(). 
		 * 
		 */

		// part3A();

		/*----------------------------------------------
		 * Part 4 - throws vs throw
		 * 
		 * Have the body of part4() throw a FileNotFoundException.
		 * Change the signature of the part4() method to say that it
		 * throws the exception. Successfully call part4() from the
		 * main(). 
		 * 
		 */

//		try {
//			part4();
//		} catch (FileNotFoundException e) {
//		}

		/*----------------------------------------------
		 * Part 5 - Custom Exception 
		 * 
		 * Create a custom exception class for if someone
		 * enters an incorrect age. Have part5() ask for the 
		 * user's age, if the age is below 18 you will throw
		 * a new instance of your custom exception and catch it.
		 * Have the method constantly ask until a valid age is displayed.
		 */

		// part5();

		/*----------------------------------------------
		 * Part 6 - Challenge - Chained Exceptions
		 * 
		 * Do some research on chained exceptions and see how it can be used with your
		 * Custom Exception.
		 *
		 */

	}

	public static void part1() {
		Scanner scan = new Scanner(System.in);

		int num = 0;

		do {
			System.out.println("Enter a number between 1 and 10");
			try {
				num = scan.nextInt();
				if (num < 1 || num > 10) {
					System.out.println("\nIllegal value, " + num + " entered.  Please try again.");
				}
			} catch (InputMismatchException i) {// although it wasnt required, I decided to make it so
				System.out.println("Wrong type entered (int is required)");
				scan.nextLine();
			}

		} while (num < 1 || num > 10);

		System.out.println("\nValue correctly entered! Thank you.");

		scan.close();

	}

	public static void part2() {

		int total = 0;

		int num = 0;

		File myFile = null;
		Scanner inputFile = null;
		try {
			myFile = new File("textFile.txt");

			inputFile = new Scanner(myFile);

			while (inputFile.hasNext()) {
				num = inputFile.nextInt();
				total += num;
			}
			System.out.println("The total value is " + total);

		} catch (FileNotFoundException f) {
			System.out.println("The file cannot be found.");
		} catch (InputMismatchException f) {
			System.out.println("Text File contains non-integers");
		} finally {
			try {
				inputFile.close();
			} catch (NullPointerException n) {// this is here because as I was testing, if the file was not found, a
												// nullpointer was thrown when i tried to close the scanner

			}
		}

	}

	public static void part3A() {
		try {
			part3B();
		} catch (ArithmeticException a) {
			System.out.println("What you did is not allowed by math. (But I caught it so its all good)");
		}

		try {
			part3D();
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println(
					"OUT OF BOUNDS! Ball to other team (Just kidding, but you can't go that far in that array! All good though because Exception has been caught)");
		}
	}

	public static void part3B() {
		part3C();

	}

	public static void part3C() {
		int x = 100 / 0;
	}

	public static void part3D() {
		int arr[] = { 1, 2, 3, 4 };

		System.out.println(arr[9]);
	}

	public static void part4() throws FileNotFoundException {
		throw new FileNotFoundException();
	}

	public static void part5() {
		Scanner scan = new Scanner(System.in);
		int age = 0;
		while (age < 18) {
			boolean ageEntered = false;
			while (!ageEntered) {
				System.out.println("Enter Age:");
				try {
					age = scan.nextInt();
					ageEntered = !ageEntered;
				} catch (InputMismatchException i) {
					System.out.println("Wrong type entered. try again");
					scan.nextLine();

				}
			}
			try {
				if (age < 18) {
					throw new UnderAge("This age is not acceptable. The age must be above 18. Try again.")
							.initCause(new IOException("IO cause."));
				} else {
					System.out.println("This age is acceptable");
				}

			} catch (Throwable u) {// this is here because of the Chained Exception
				System.out.println(u);
			}
		}
		scan.close();

	}

}
