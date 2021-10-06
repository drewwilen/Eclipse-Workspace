package TestError;

import java.util.*;

public class Main {

	public static void main(String[] args) {

//		ArrayList<String> wordList = new ArrayList<String>();
//		System.out.println(wordList.get(0));

//	 int x = (Integer) null;
//	 System.out.println(x);

		// System.out.println(0/0);
		// throw new java.lang.NullPointerException("There is someone in your house. GET
		// OUT.");

//		try {
//			throw new Exception("Custom Message");
////			//int x = 5 / 0;
////			Integer i = null;
////			i.toString();
//		} catch (ArithmeticException e) {
//			System.out.println("! - Arithmetic Exception FOUND - !");
//			System.out.println("Exception caught : " + e);
//			System.out.println("Message: " + e.getMessage());
//			e.printStackTrace();
//		} catch (NullPointerException e) {
//			System.out.println("! - NullPointer Exception FOUND - !");
//		} catch (Exception e) {
//			System.out.println("! - OTHER Exception FOUND - !");
//			System.out.println(e);
//		} finally {
//			System.out.println("Drew Wilenzick is a beast");
//		}
		// -----------------------------------------
		method1();
		System.out.println("End of Da Main");
	}

	public static void method1() {
		try {
			method2();

		} catch (NullPointerException e) {
			System.out.println("I'm Chillin bro");
			System.out.println(e);
		}
	}

	public static void method2() {
		method3(0);
	}

	public static void method3(int i) {
		// if (i == 0) {
		throw new NullPointerException();
//		} else {
//			throw new ArithmeticException();
//		}
	}

}
